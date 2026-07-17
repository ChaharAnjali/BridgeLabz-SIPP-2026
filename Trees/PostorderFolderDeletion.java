package Trees;

// import java.util.*;

class Node {

    String name;
    Node left;
    Node right;

    Node(String name) {
        this.name = name;
        left = null;
        right = null;
    }
}

public class PostorderFolderDeletion {

    static void deleteFolderTree(Node node) {

        if (node == null)
            return;

        deleteFolderTree(node.left);

        deleteFolderTree(node.right);

        deleteNode(node);
    }

    static void deleteNode(Node node) {

        System.out.println("Deleting: " + node.name);
    }

    public static void main(String[] args) {

        Node root = new Node("Root Folder");

        root.left = new Node("Documents");

        root.right = new Node("Pictures");

        root.left.left = new Node("Resume.pdf");

        root.left.right = new Node("Notes.txt");

        deleteFolderTree(root);
    }
}