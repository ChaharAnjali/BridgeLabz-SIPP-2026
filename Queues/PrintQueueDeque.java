package Queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrintQueueDeque {

    static class PrintJobQueue {

        private Deque<Integer> printQueue;

        PrintJobQueue() {

            printQueue = new ArrayDeque<>();

        }

        // Normal job added at back
        void submitJob(int jobId) {

            printQueue.addLast(jobId);
        }

        // Urgent job added at front
        void submitUrgentJob(int jobId) {

            printQueue.addFirst(jobId);
        }

        // Printer takes job from front
        int printNextJob() {

            if (printQueue.isEmpty()) {

                throw new RuntimeException(
                        "Print queue is empty");
            }

            return printQueue.removeFirst();
        }

        void displayQueue() {

            System.out.println(printQueue);
        }
    }

    public static void main(String[] args) {

        PrintJobQueue queue = new PrintJobQueue();

        // Normal jobs
        queue.submitJob(101);
        queue.submitJob(102);
        queue.submitJob(103);

        System.out.println(
                "After normal jobs:");

        queue.displayQueue();

        // Urgent job
        queue.submitUrgentJob(999);

        System.out.println(
                "After urgent job:");

        queue.displayQueue();

        // Printing
        System.out.println(
                "Printing Job: "
                        + queue.printNextJob());

        System.out.println(
                "Printing Job: "
                        + queue.printNextJob());

        System.out.println(
                "Remaining Queue:");

        queue.displayQueue();
    }
}