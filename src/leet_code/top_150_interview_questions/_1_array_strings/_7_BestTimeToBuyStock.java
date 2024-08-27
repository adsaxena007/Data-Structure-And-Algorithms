package leet_code.top_150_interview_questions._1_array_strings;

import java.util.*;

public class _7_BestTimeToBuyStock {
    public static int maxProfit(int[] prices) {

        Map<Integer,Integer> maxElement = new HashMap<>();
        for(int i = prices.length-1; i>=0;i--){
            if(i==prices.length-1){
                maxElement.put(i,prices[i]);
            } else {
                int max = maxElement.get(i+1);
                if(max >= prices[i+1]){
                    maxElement.put(i, max);
                } else {
                    maxElement.put(i,prices[i+1]);
                }
            }
        }
        int min= prices[0];
        int profit= maxElement.get(0) - prices[0];

        for(int i=1;i<prices.length;i++){
            if( prices[i]<min && (maxElement.get(i) - prices[i]) > profit ){
                min = prices[i];
                profit = maxElement.get(i) - prices[i];
            }
        }
        System.out.println(profit);
        return Math.max(profit, 0);
    }

    public static void main(String[] args) {

        int nums = maxProfit(new int [] {7,6,4,3,1});

        System.out.println(nums);
    }
}
