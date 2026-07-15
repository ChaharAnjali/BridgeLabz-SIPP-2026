package LinkedList;

class Node {
    String url;
    Node next;

    Node(String url) {
        this.url = url;
        this.next = null;
    }
}

public class RedirectLoop {

    static boolean hasRedirectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        if (hasRedirectLoop(a))
            System.out.println("Redirect loop detected.");
        else
            System.out.println("No redirect loop found.");
    }
}
