package leet_code.top_150_interview_questions._11_BinarySearchTree;

import leet_code.top_150_interview_questions._9_BinaryTreeGeneral.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _94_KthSmallestElementInABST {
    List<Integer> list;
    public void inorder(TreeNode root) {
        if(root == null)
            return ;

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }



    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        inorder(root);
        return list.get(k-1);
    }

    public static void main(String[] args) {
        Integer []nodes = {1,null,2};

        TreeNode tree = TreeNode.createTree(nodes);
        _94_KthSmallestElementInABST ob = new _94_KthSmallestElementInABST();
        System.out.println(ob.kthSmallest(tree, 2));
    }
}
