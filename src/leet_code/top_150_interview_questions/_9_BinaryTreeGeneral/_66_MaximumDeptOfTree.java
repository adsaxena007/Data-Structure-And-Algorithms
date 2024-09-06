package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;

public class _66_MaximumDeptOfTree {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
