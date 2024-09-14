package leet_code.top_150_interview_questions._10_BinaryTreeBFS;

import leet_code.top_150_interview_questions._9_BinaryTreeGeneral.TreeNode;

import java.util.ArrayList;
import java.util.List;



public class _90_AverageOfLevelsInBinaryTree {
    List<Double> result;
    List<Data> queue;

    public List<Double> averageOfLevels(TreeNode root) {
        result = new ArrayList<>();
        queue = new ArrayList<>();

        if(root ==null)
            return result;

        queue.add(new Data(root, 0));

        double average = 0;
        int count = 0;
        while (!queue.isEmpty()){
            Data t = queue.removeFirst();
            TreeNode node = t.node;
            if(node !=null){
                average = average + node.val;
                count++;

                if(node.left !=null)
                    queue.add(new Data(node.left, t.level+1));

                if(node.right !=null)
                    queue.add(new Data(node.right, t.level+1));

                if(queue.isEmpty() || queue.getFirst().level != t.level){
                    result.add(average/count);
                    average=0;
                    count=0;
                }
            }
        }

        return result;
    }
}
