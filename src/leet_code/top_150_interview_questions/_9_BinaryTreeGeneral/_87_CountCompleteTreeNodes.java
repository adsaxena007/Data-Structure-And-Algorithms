package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;

public class _87_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
