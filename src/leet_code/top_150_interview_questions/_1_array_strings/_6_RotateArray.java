package leet_code.top_150_interview_questions._1_array_strings;

import java.util.Arrays;

public class _6_RotateArray {
    public int[] rotateBy1Place(int[] nums){
        int lastElement = nums[nums.length-1];
        int current=nums[0];
        for (int i = 1;i<nums.length;i++){
            int temp = nums[i];
            nums[i]=current;
            current=temp;
        }
        nums[0]=lastElement;

        return nums;
    }
    public void rotateBruteForce(int[] nums, int k) {
        for(int i =0;i<k;i++){
            nums = rotateBy1Place(nums);
        }
    }

    public int [] rotate(int[] nums, int k) {
        int rotateTimes = k%nums.length;
        int tempArray []= new int[rotateTimes];
        int j=0;
        for(int i = (nums.length-rotateTimes);i<nums.length;i++){
            tempArray[j] = nums[i];
            j++;
        }

        int l=nums.length-1;
        for(int i = ((nums.length-1)-rotateTimes);i>=0;i--){
            nums[l] = nums[i];
            l--;
        }
        for(int i=0;i<tempArray.length;i++){
            nums[i]=tempArray[i];
        }

        return nums;

    }

    public static void main(String[] args) {
        _6_RotateArray obj = new _6_RotateArray();
        int nums []= obj.rotate(new int [] {1,2,3,4,5,6,7},3);

        Arrays.stream(nums).forEach(System.out::print);
    }
}
