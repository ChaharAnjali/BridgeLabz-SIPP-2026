package Queues;

public class CircularQueuePacketBuffer {

    static class PacketBuffer {

        private int[] data;
        private int front;
        private int count;

        PacketBuffer(int capacity) {

            data = new int[capacity];

            front = 0;
            count = 0;
        }

        // Add packet
        boolean enqueue(int packetId) {

            // Buffer full
            if (count == data.length) {

                return false;
            }

            int index = (front + count) % data.length;

            data[index] = packetId;

            count++;

            return true;
        }

        // Remove packet
        int dequeue() {

            // Buffer empty
            if (count == 0) {

                throw new RuntimeException(
                        "Buffer empty");
            }

            int packet = data[front];

            front = (front + 1) % data.length;

            count--;

            return packet;
        }

        boolean isEmpty() {

            return count == 0;
        }

        boolean isFull() {

            return count == data.length;
        }
    }

    public static void main(String[] args) {

        PacketBuffer buffer = new PacketBuffer(5);

        System.out.println(
                buffer.enqueue(101));

        System.out.println(
                buffer.enqueue(102));

        System.out.println(
                buffer.enqueue(103));

        System.out.println(
                "Processed Packet: "
                        + buffer.dequeue());

        System.out.println(
                "Processed Packet: "
                        + buffer.dequeue());

        // Reusing freed space
        buffer.enqueue(104);
        buffer.enqueue(105);
        buffer.enqueue(106);

        System.out.println(
                "Processed Packet: "
                        + buffer.dequeue());

        System.out.println(
                "Processed Packet: "
                        + buffer.dequeue());
    }
}
