package leet_code.top_150_interview_questions._10_BinaryTreeBFS;

import leet_code.top_150_interview_questions._9_BinaryTreeGeneral.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _91_BinaryTreeLevelOrderTraversal {
    List<List<Integer>> result;
    List<Data> queue;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        queue = new ArrayList<>();

        if(root ==null)
            return result;

        queue.add(new Data(root, 0));

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            Data t = queue.removeFirst();
            TreeNode node = t.node;
            if(node !=null){
                list.add(node.val);
                if(node.left !=null)
                    queue.add(new Data(node.left, t.level+1));

                if(node.right !=null)
                    queue.add(new Data(node.right, t.level+1));

                if(queue.isEmpty() || queue.getFirst().level != t.level){
                    result.add(list);
                    list = new ArrayList<>();
                }
            }
        }

        return result;
    }
}
