package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < nodes.length) {
            TreeNode current = queue.poll();

            if (nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.add(current.left);
            }
            i++;

            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void printCompactTree(TreeNode root) {
        if (root == null) {
            return;
        }

        Map<Integer, List<String>> levels = new HashMap<>();
        buildCompactTree(root, levels, 0, 0);

        for (int i = 0; i < levels.size(); i++) {
            List<String> level = levels.get(i);

            // Check if this level is all "null"
            boolean allNull = level.stream().allMatch(val -> val.equals("null"));
            if (allNull) {
                break; // stop printing once we hit an all "null" level
            }

            for (String val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static void buildCompactTree(TreeNode node, Map<Integer, List<String>> levels, int level, int pos) {
        levels.putIfAbsent(level, new ArrayList<>());

        // Ensure the list is large enough to hold the value at the current position
        List<String> levelList = levels.get(level);
        while (levelList.size() <= pos) {
            levelList.add("null"); // fill with "null" to maintain structure
        }

        if (node != null) {
            levelList.set(pos, String.valueOf(node.val));
            buildCompactTree(node.left, levels, level + 1, pos * 2);
            buildCompactTree(node.right, levels, level + 1, pos * 2 + 1);
        }
    }
}
