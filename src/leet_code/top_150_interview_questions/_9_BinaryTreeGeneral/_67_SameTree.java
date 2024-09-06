package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;


public class _67_SameTree {

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
}
