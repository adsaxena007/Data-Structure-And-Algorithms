package leet_code.top_150_interview_questions._14_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _107_Permutations {
    List<List<Integer>> result;


    public void generatePermutations(int[] nums, List<Integer> current, boolean[] visited){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                current.add(nums[i]);
                generatePermutations(nums, current, visited);
                current.removeLast();
                visited[i] = false;
            }
        }

    }


    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        generatePermutations(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    public static void main(String[] args) {
        _107_Permutations ob = new _107_Permutations();
        int []nums = {1,2,3};
        System.out.println(ob.permute(nums));
    }
}
