package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;

import java.util.IdentityHashMap;
import java.util.Map;

public class _88_LowestCommonAncestor {
    private boolean foundP;
    private boolean foundQ;
    private TreeNode lca;

    public boolean isCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null)
            return false;

        if(root == p ){
            foundP=true;
        }

        if(root==q){
            foundQ=true;
        }


        isCommonAncestor(root.left,p,q);
        isCommonAncestor(root.right,p,q);

        return foundQ && foundP;
    }

    public void getLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null)
            return;

        foundP=false;
        foundQ=false;

        if(isCommonAncestor(root, p, q)){
            lca = root;
        }else {
            return;
        }

        getLowestCommonAncestor(root.left,p,q);
        getLowestCommonAncestor(root.right,p,q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getLowestCommonAncestor(root,p,q);
        return lca;
    }
}
