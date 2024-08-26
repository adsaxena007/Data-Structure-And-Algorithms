package leet_code;

public class _16_TwoSum {
    public int[] twoSum(int[] numbers, int target) {

        int start =1;
        int end =numbers.length;
        int sum = 0;

        for(int i =0;i< numbers.length;i++){
            if(numbers[start-1] + numbers[end-1] == target){
                return new int[]{start, end};
            }

            if( numbers[start-1] + numbers[end-1] < target){
                start++;
            }

            if( numbers[start-1] + numbers[end-1] > target){
                end--;
            }
        }
        return new int[]{start, end};
    }
}
