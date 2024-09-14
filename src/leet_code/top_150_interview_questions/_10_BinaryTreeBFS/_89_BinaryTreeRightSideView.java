package leet_code.top_150_interview_questions._10_BinaryTreeBFS;

import leet_code.top_150_interview_questions._9_BinaryTreeGeneral.TreeNode;
import leet_code.top_150_interview_questions._9_BinaryTreeGeneral._82_FlattenBinaryTreeToLinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class _89_BinaryTreeRightSideView {
    List<Integer> result;
    List<Data> queue;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        queue = new ArrayList<>();

        if(root ==null)
            return result;

        queue.add(new Data(root, 0));

        while (!queue.isEmpty()){
            Data t = queue.removeFirst();
            TreeNode node = t.node;

            if(node !=null){

                if(node.left !=null)
                    queue.add(new Data(node.left, t.level+1));

                if(node.right !=null)
                    queue.add(new Data(node.right, t.level+1));

                if(queue.isEmpty() || queue.getFirst().level != t.level){
                    result.add(node.val);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        _89_BinaryTreeRightSideView ob = new _89_BinaryTreeRightSideView();


        Integer[] root = {1,2,3,4};
        TreeNode tree = TreeNode.createTree(root);
        TreeNode.printCompactTree(tree);
        System.out.println();
        System.out.println(ob.rightSideView(tree));
    }
}
