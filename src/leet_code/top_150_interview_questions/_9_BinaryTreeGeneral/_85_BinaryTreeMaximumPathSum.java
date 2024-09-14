package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;

public class _85_BinaryTreeMaximumPathSum {
    Integer maxSum;
    Integer maxSumIncludingNode;
    public int getMaxPathSum(TreeNode root) {
        if(root==null)
            return -1000000000;

        if(root.right==null && root.left==null){
            maxSum = maxSum != null ? Math.max(maxSum,root.val) : root.val;
            return root.val;
        }


        int a = getMaxPathSum(root.left);
        int b = getMaxPathSum(root.right);
        int c = root.val + a + b;
        int d = root.val + b;
        int e = root.val + a;
        int current = Math.max(d,Math.max(root.val,e));
        maxSum = maxSum != null ? Math.max(maxSum,current) : current;
        maxSumIncludingNode = maxSumIncludingNode != null ? Math.max(maxSum,Math.max(maxSumIncludingNode,c)) : c;
        return current;
    }

    public  int maxPathSum(TreeNode root) {
        int a = getMaxPathSum(root);
        if (maxSumIncludingNode != null && maxSum != null)
            return Math.max(maxSum, Math.max(a, maxSumIncludingNode));
        else if (maxSum != null)
            return Math.max(maxSum, a);
        else if (maxSumIncludingNode != null)
            return Math.max(maxSumIncludingNode, a);
        else
            return a;
    }



    public static void main(String[] args) {
        Integer[] root = {-10,9,20,null,null,15,7};
        TreeNode tree = TreeNode.createTree(root);
        TreeNode.printCompactTree(tree);
        _85_BinaryTreeMaximumPathSum ob = new  _85_BinaryTreeMaximumPathSum();
        System.out.println();
        System.out.println(ob.maxPathSum(tree));
    }
}
