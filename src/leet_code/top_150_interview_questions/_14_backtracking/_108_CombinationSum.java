package leet_code.top_150_interview_questions._14_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _108_CombinationSum {
    List<List<Integer>> result;

    public void generateCombination(int[] candidates, List<Integer> current, int target, int sum, int start){
        if(sum == target){
            result.add(new ArrayList<>(current));
            return;
        }

        if(sum > target)
            return;

        for(int i=start;i<candidates.length;i++){
                current.add(candidates[i]);
                generateCombination(candidates,current,target, sum + candidates[i], i);
                current.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        generateCombination(candidates, new ArrayList<>(), target, 0, 0);
        return result;
    }

    public static void main(String[] args) {
        _108_CombinationSum ob = new _108_CombinationSum();
        int []candidates = {2,3,6,7};
        System.out.println(ob.combinationSum(candidates, 7));
    }
}
