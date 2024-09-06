package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;

import java.util.Arrays;

public class _79_ConstructTreeFromInAndPreOrder {
    public static TreeNode build(int[] preorder, int[] inorder, int index) {
        if(preorder.length==0 || inorder.length==0){
            return null;
        }

        if(inorder.length == 1){
            return new TreeNode(preorder[index]);
        }

        int leftTreeLen=0;
        for (int k : inorder) {
            if (k == preorder[index]) {
                break;
            }
            leftTreeLen++;
        }

        int []leftInorderTree = new int[leftTreeLen];
        for(int i=0;i<leftTreeLen;i++){
            leftInorderTree[i] = inorder[i];
        }
        TreeNode node = new TreeNode(preorder[index]);
        node.left =  build(preorder, leftInorderTree, index + 1);

        int rightTreeLen = inorder.length - (leftTreeLen+2) +1;
        if(rightTreeLen>0){
            int []rightInorderTree = new int[rightTreeLen];
            int j=0;
            for(int i=leftTreeLen+1;i<inorder.length;i++){
                rightInorderTree[j] = inorder[i];
                j++;
            }
            node.right =  build(preorder, rightInorderTree, index + leftTreeLen + 1);
        }
        return node;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0);
    }

    public static void main(String[] args) {

        int[] preOrder = {1,2,4,8,9,5,3,6,7};
        int[] inOrder = {8,4,9,2,5,1,6,3,7};

        Integer[] tree = {1,2,3,4,5,6,7,8,9};
        TreeNode.printCompactTree(TreeNode.createTree(tree));
        System.out.println();
        TreeNode.printCompactTree(buildTree(preOrder,inOrder));
    }
}
