package LinkedList;

class Node {
    int pageId;
    Node next;

    Node(int pageId) {
        this.pageId = pageId;
        this.next = null;
    }
}

public class BrowserHistory {

    static Node reverseHistory(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.pageId + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original History:");
        printList(head);

        head = reverseHistory(head);

        System.out.println("Reversed History:");
        printList(head);
    }
}
