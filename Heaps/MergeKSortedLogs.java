package Heaps;

import java.util.*;

class LogEntry {

    int timestamp;
    String message;

    LogEntry(int timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    @Override
    public String toString() {
        return timestamp + " : " + message;
    }
}

public class MergeKSortedLogs {

    static List<LogEntry> mergeKSortedLogs(
            List<List<LogEntry>> sources) {

        // Min Heap based on timestamp
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> sources.get(a[0]).get(a[1]).timestamp -
                        sources.get(b[0]).get(b[1]).timestamp);

        // Add first log entry from every server
        for (int i = 0; i < sources.size(); i++) {

            if (!sources.get(i).isEmpty()) {

                minHeap.offer(new int[] { i, 0 });
            }
        }

        List<LogEntry> merged = new ArrayList<>();

        while (!minHeap.isEmpty()) {

            // Remove smallest timestamp
            int[] top = minHeap.poll();

            int sourceIdx = top[0];
            int elemIdx = top[1];

            LogEntry current = sources.get(sourceIdx).get(elemIdx);

            merged.add(current);

            // Add next entry from same source
            if (elemIdx + 1 < sources.get(sourceIdx).size()) {

                minHeap.offer(
                        new int[] { sourceIdx, elemIdx + 1 });
            }
        }

        return merged;
    }

    public static void main(String[] args) {

        List<List<LogEntry>> logs = new ArrayList<>();

        logs.add(Arrays.asList(
                new LogEntry(10, "Server A started"),
                new LogEntry(30, "Server A error"),
                new LogEntry(50, "Server A stopped")));

        logs.add(Arrays.asList(
                new LogEntry(15, "Server B started"),
                new LogEntry(25, "Server B warning"),
                new LogEntry(60, "Server B stopped")));

        logs.add(Arrays.asList(
                new LogEntry(5, "Server C started"),
                new LogEntry(40, "Server C crash")));

        List<LogEntry> result = mergeKSortedLogs(logs);

        System.out.println("Merged Timeline:");

        for (LogEntry log : result) {

            System.out.println(log);
        }
    }
}