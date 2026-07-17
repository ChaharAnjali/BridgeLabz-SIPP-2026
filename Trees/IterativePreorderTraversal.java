package Trees;

import java.util.*;

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

public class IterativePreorderTraversal {

    static List<Integer> iterativePreorder(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Deque<Node> stack = new ArrayDeque<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            Node node = stack.pop();

            result.add(node.val);

            if (node.right != null)
                stack.push(node.right);

            if (node.left != null)
                stack.push(node.left);
        }

        return result;
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<Integer> ans = iterativePreorder(root);

        System.out.println(ans);
    }
}
