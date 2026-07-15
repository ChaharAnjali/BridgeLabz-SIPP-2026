package LinkedList;

class Node {
    int timestamp;
    Node next;

    Node(int timestamp) {
        this.timestamp = timestamp;
        this.next = null;
    }
}

public class MergeLogStreams {

    static Node mergeLogStreams(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.timestamp <= b.timestamp) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        tail.next = (a != null) ? a : b;

        return dummy.next;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.timestamp + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(3);
        a.next.next = new Node(5);

        Node b = new Node(2);
        b.next = new Node(4);
        b.next.next = new Node(6);

        Node merged = mergeLogStreams(a, b);

        System.out.println("Merged Log Stream:");
        printList(merged);
    }
}
