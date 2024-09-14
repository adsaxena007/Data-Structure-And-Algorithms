package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;

public class _82_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root==null)
            return;

        flatten(root.right);
        flatten(root.left);
        if(root.left!=null){
            TreeNode t = root.left;
            while (t.right != null){
                t = t.right;
            }
            t.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
    public static void main(String[] args) {
        Integer[] root = {1,2,5,3,4,null,6};
        TreeNode tree = TreeNode.createTree(root);
        TreeNode.printCompactTree(tree);
        _82_FlattenBinaryTreeToLinkedList ob = new  _82_FlattenBinaryTreeToLinkedList();
        ob.flatten(tree);
        System.out.println();
        TreeNode.printCompactTree(tree);
    }
}
