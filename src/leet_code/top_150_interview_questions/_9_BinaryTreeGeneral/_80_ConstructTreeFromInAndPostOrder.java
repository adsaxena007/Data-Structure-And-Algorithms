package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;

public class _80_ConstructTreeFromInAndPostOrder {
    public static TreeNode build(int[] postOrder, int[] inorder, int index) {
        if(postOrder.length==0 || inorder.length==0){
            return null;
        }

        if(inorder.length == 1){
            return new TreeNode(inorder[0]);
        }

        int leftTreeLen=0;
        for (int k : inorder) {
            if (k == postOrder[index]) {
                break;
            }
            leftTreeLen++;
        }

        int []leftInorderTree = new int[leftTreeLen];

        for(int i=0;i<leftTreeLen;i++){
            leftInorderTree[i] = inorder[i];
        }

        TreeNode node = new TreeNode(postOrder[index]);
        int rightTreeLen = inorder.length - (leftTreeLen + 2) +1;
        node.left =  build(postOrder, leftInorderTree, index - rightTreeLen - 1);


        if(rightTreeLen>0){
            int []rightInorderTree = new int[rightTreeLen];
            int j=0;
            for(int i=leftTreeLen+1;i<inorder.length;i++){
                rightInorderTree[j] = inorder[i];
                j++;
            }
            node.right =  build(postOrder, rightInorderTree, index - 1);
        }
        return node;
    }

    public static TreeNode buildTree(int[] inorder, int[] postOrder ) {
        return build(postOrder,inorder,postOrder.length-1);
    }

    public static void main(String[] args) {

//        int[] postOrder = {8,9,4,5,2,6,7,3,1};
//        int[] inOrder = {8,4,9,2,5,1,6,3,7};
//
//        Integer[] tree = {1,2,3,4,5,6,7,8,9};
//        TreeNode.printCompactTree(TreeNode.createTree(tree));
//        System.out.println();
//        TreeNode.printCompactTree(buildTree(inOrder, postOrder));


        int[] postOrder = {2,1,4,3};
        int[] inOrder = {1,2,3,4};

        Integer[] tree = {3,1,4,null,2};
        TreeNode.printCompactTree(TreeNode.createTree(tree));
        System.out.println();
        TreeNode.printCompactTree(buildTree(inOrder, postOrder));
    }
}
