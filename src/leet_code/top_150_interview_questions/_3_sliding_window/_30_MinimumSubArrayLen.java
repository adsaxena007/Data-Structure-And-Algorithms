package leet_code.top_150_interview_questions._3_sliding_window;

public class _30_MinimumSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        Integer minWindow= Integer.MAX_VALUE;
        int left=0;
        int right=0;
        int sum = nums[left];

        if(sum >= target){
            return 1;
        }

        while (left<=right && right < nums.length-1){
            right++;
            sum = sum + nums[right];
            if(sum >= target){
                minWindow = Math.min(minWindow, right-left+1);
            }
            while(sum - nums[left] >= target){
                sum = sum - nums[left];
                left++;
                minWindow = Math.min(minWindow, right-left+1);
            }
        }

        if(sum < target)
            return 0;

        return minWindow;
    }

    public static void main(String[] args) {
        _30_MinimumSubArrayLen minimumSubArrayLen = new _30_MinimumSubArrayLen();
//        System.out.println(minimumSubArrayLen.minSubArrayLen( 7, new int[]{2,3,1,2,4,3}));
//        System.out.println(minimumSubArrayLen.minSubArrayLen( 4, new int[]{1,4,4}));
//        System.out.println(minimumSubArrayLen.minSubArrayLen( 11, new int[]{1,1,1,1,1,1,1,1}));
//        System.out.println(minimumSubArrayLen.minSubArrayLen( 213, new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
        System.out.println(minimumSubArrayLen.minSubArrayLen( 15, new int[]{5,1,3,5,10,7,4,9,2,8}));

    }
}
