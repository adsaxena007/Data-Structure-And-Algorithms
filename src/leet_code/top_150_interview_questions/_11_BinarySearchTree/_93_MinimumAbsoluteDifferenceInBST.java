package leet_code.top_150_interview_questions._11_BinarySearchTree;

import leet_code.top_150_interview_questions._9_BinaryTreeGeneral.TreeNode;

public class _93_MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root, Integer min, Integer max) {
        if(root==null)
            return Integer.MAX_VALUE;

        int a = root.left !=null ? Math.abs(root.val - root.left.val): Integer.MAX_VALUE;
        int b = root.right !=null ? Math.abs(root.val - root.right.val) : Integer.MAX_VALUE;
        int e = min != null ? Math.abs(root.val - min) : Integer.MAX_VALUE;
        int f = max!=null ? Math.abs(root.val - max):Integer.MAX_VALUE;


        return Math.min(getMinimumDifference(root.left, min, root.val),
                Math.min(getMinimumDifference(root.right, root.val, max),
                        Math.min(a,Math.min(b,Math.min(e,f)))));
    }

    public int getMinimumDifference(TreeNode root) {
        if(root==null)
            return 0;

        return getMinimumDifference(root,null,null);
    }

    public static void main(String[] args) {
        Integer[] node ={236,104,701,null,227,null,911};

        TreeNode t = TreeNode.createTree(node);

        TreeNode.printCompactTree(t);

        System.out.println();
        _93_MinimumAbsoluteDifferenceInBST ob = new _93_MinimumAbsoluteDifferenceInBST();
        System.out.println(ob.getMinimumDifference(t));
    }
}
