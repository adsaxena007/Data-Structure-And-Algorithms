package data_structures.trees.binary_tree.traversals;

import leet_code.top_150_interview_questions._9_BinaryTreeGeneral.TreeNode;

public class ValidateBinaryTree {
    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true; // An empty tree is a valid BST
        }

        // Check if the current node's value violates the BST properties
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        // Recursively validate the left and right subtrees with updated constraints
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public static void main(String[] args) {
        Integer[] node ={5,4,7,null,null,6,8};

        TreeNode t = TreeNode.createTree(node);

        TreeNode.printCompactTree(t);

        ValidateBinaryTree ob = new ValidateBinaryTree();
        System.out.println(ob.isValidBST(t));
    }
}
