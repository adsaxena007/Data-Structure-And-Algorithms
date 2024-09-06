package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    // Method to create a sample binary tree
    public static Node createTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;

        // Create the root node
        Node root = new Node(arr[0]);

        // Queue to help in level-order insertion
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; // Index to track array elements
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            // Insert the left child
            if (arr[i] != null) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Insert the right child (if available)
            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Method to print the tree in multi-level format (level-order traversal)
    public static void printTree(Node root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                System.out.print(current.val + " ");

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            System.out.println(); // Move to the next line after printing all nodes at the current level
        }
    }

    // In-order traversal (if desired)
    public static void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }
}

