package leet_code.top_150_interview_questions._14_backtracking;

import java.util.ArrayList;
import java.util.List;

public class _106_Combinations {

    List<List<Integer>> result;



    public void generateCombinations(int n, int k, List<Integer> current ) {
        if(k==0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if(n==0)
            return;


        current.add(n);
        generateCombinations(n-1, k-1, current);
        current.removeLast();
        generateCombinations(n-1, k, current);
    }


    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        generateCombinations(n,k, new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        _106_Combinations ob = new _106_Combinations();

        System.out.println(ob.combine(4,3));
    }
}
