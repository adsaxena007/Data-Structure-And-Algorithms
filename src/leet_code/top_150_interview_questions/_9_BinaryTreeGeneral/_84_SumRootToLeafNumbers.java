package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;

public class _84_SumRootToLeafNumbers {
    public int getSumNumbers(TreeNode root, String number) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return Integer.parseInt(number+ root.val);

        return getSumNumbers(root.left,number + root.val)
                + getSumNumbers(root.right, number + root.val);
    }

    public int sumNumbers(TreeNode root) {
        return getSumNumbers(root, "");
    }

    public static void main(String[] args) {
        Integer[] root = {1,2,3};
        TreeNode tree = TreeNode.createTree(root);
        TreeNode.printCompactTree(tree);
        _84_SumRootToLeafNumbers ob = new  _84_SumRootToLeafNumbers();
        System.out.println(ob.sumNumbers(tree));
    }
}
