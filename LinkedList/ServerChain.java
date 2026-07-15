package LinkedList;

class Node {
    int serverId;
    Node next;

    Node(int serverId) {
        this.serverId = serverId;
        this.next = null;
    }
}

public class ServerChain {

    static Node findMiddleServer(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.serverId + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(101);
        head.next = new Node(102);
        head.next.next = new Node(103);
        head.next.next.next = new Node(104);
        head.next.next.next.next = new Node(105);

        System.out.println("Server Chain:");
        printList(head);

        Node middle = findMiddleServer(head);
        System.out.println("Middle Server: " + middle.serverId);
    }
}