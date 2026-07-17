package BST;

class Node {

    int val;
    Node left;
    Node right;

    Node(int val) {

        this.val = val;
        left = null;
        right = null;
    }
}

public class BSTValidation {

    static boolean isValidBST(Node root) {

        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean validate(Node node, long min, long max) {

        if (node == null)
            return true;

        if (node.val <= min || node.val >= max)
            return false;

        return validate(node.left, min, node.val)
                &&
                validate(node.right, node.val, max);
    }

    public static void main(String[] args) {

        Node root = new Node(10);

        root.left = new Node(5);

        root.right = new Node(15);

        root.right.left = new Node(6);

        System.out.println(isValidBST(root));
    }
}