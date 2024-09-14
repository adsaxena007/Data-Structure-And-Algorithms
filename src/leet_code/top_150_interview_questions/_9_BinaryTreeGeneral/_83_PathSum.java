package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;

public class _83_PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null)
            return false;

        if(root.left == null && root.right == null && targetSum-root.val == 0)
            return true;

        return hasPathSum(root.right, targetSum-root.val) || hasPathSum(root.left, targetSum-root.val);
    }

    public static void main(String[] args) {
        Integer[] root = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode tree = TreeNode.createTree(root);
        TreeNode.printCompactTree(tree);
        _83_PathSum ob = new  _83_PathSum();
        System.out.println(ob.hasPathSum(tree, 22));
    }
}
