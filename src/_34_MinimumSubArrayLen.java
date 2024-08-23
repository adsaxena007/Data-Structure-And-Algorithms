
import java.util.Arrays;

public class _34_MinimumSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if(sum < target)
            return 0;

        int left =0;
        int right = nums.length-1;
        int result = nums.length;


        while (left < right){
            if((sum - nums[left]) >= target) {
                sum = sum - nums[left];
                left++;
                result--;
            }

            if((sum - nums[right]) >= target){
                sum = sum - nums[right];
                right--;
                result--;
            }
            if((sum - nums[left]) <target && (sum - nums[right]) < target){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _34_MinimumSubArrayLen minimumSubArrayLen = new _34_MinimumSubArrayLen();
        System.out.println(minimumSubArrayLen.minSubArrayLen( 7, new int[]{2,3,1,2,4,3}));
        System.out.println(minimumSubArrayLen.minSubArrayLen( 4, new int[]{1,4,4}));
        System.out.println(minimumSubArrayLen.minSubArrayLen( 11, new int[]{1,1,1,1,1,1,1,1}));
        System.out.println(minimumSubArrayLen.minSubArrayLen( 213, new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
        System.out.println(minimumSubArrayLen.minSubArrayLen( 15, new int[]{5,1,3,5,10,7,4,9,2,8}));

    }
}
