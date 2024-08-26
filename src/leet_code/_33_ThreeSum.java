package leet_code;

import java.util.*;

public class _33_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();


        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;
            if(i>0 && nums[i] == nums[i-1])
                continue;

            int sum = -nums[i];
            while(left<right){
                if(nums[left] + nums[right] == sum){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if(nums[left] + nums[right] < sum) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _33_ThreeSum ts = new _33_ThreeSum();

        System.out.println(ts.threeSum(new int[]{0,0,0}));
    }
}
