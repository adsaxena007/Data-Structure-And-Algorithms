package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;


public class _67_SymmetricTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }

        if(p==null)
            return false;

        if(q==null)
            return false;

        return q.val == p.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;

        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        TreeNode invertedTree = invertTree(root);
        return isSameTree(root.left, invertedTree);
    }
}
