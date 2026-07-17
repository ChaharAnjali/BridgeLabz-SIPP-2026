package BST;

// import java.util.*;

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

public class BSTDelete {

    static Node delete(Node node, int sku) {

        if (node == null)
            return null;

        if (sku < node.val) {

            node.left = delete(node.left, sku);

        }

        else if (sku > node.val) {

            node.right = delete(node.right, sku);

        }

        else {

            // Case 1: Leaf Node

            if (node.left == null && node.right == null) {

                return null;
            }

            // Case 2: One Child

            if (node.left == null) {

                return node.right;
            }

            if (node.right == null) {

                return node.left;
            }

            // Case 3: Two Children

            Node successor = node.right;

            while (successor.left != null) {

                successor = successor.left;
            }

            node.val = successor.val;

            node.right = delete(node.right, successor.val);
        }

        return node;
    }

    static void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);

        System.out.print(root.val + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(50);

        root.left = new Node(30);

        root.right = new Node(70);

        root.left.left = new Node(20);

        root.left.right = new Node(40);

        root.right.left = new Node(60);

        root.right.right = new Node(80);

        root = delete(root, 50);

        inorder(root);
    }
}
