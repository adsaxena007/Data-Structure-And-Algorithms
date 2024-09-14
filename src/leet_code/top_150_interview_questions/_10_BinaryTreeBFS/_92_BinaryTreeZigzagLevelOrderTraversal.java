package leet_code.top_150_interview_questions._10_BinaryTreeBFS;

import leet_code.top_150_interview_questions._9_BinaryTreeGeneral.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _92_BinaryTreeZigzagLevelOrderTraversal {
    List<List<Integer>> result;
    List<Data> queue;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        result = new ArrayList<>();
        queue = new ArrayList<>();

        if(root ==null)
            return result;

        queue.add(new Data(root, 0));
        int count=0;
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
                    count++;
                    if(count%2==0){
                        result.add(list.reversed());
                    }else{
                        result.add(list);
                    }
                    list = new ArrayList<>();

                }
            }
        }

        return result;
    }
}
