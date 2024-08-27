package leet_code.top_150_interview_questions._1_array_strings;

import java.util.Arrays;

public class _13_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int product=1;
        int countOfZero=0;
        for (int num : nums) {
            if (num != 0)
                product = product * num;

            if (num == 0)
                countOfZero++;
        }

        for(int i= 0; i< nums.length;i++){
            if(countOfZero>1)
                nums[i] = 0;

            if(countOfZero == 1 && nums[i]!=0){
                nums[i] = 0;
                continue;
            }

            if(countOfZero == 1 && nums[i]==0){
                nums[i] = product;
                continue;
            }

            if(countOfZero == 0){
                nums[i] = product/nums[i];
                continue;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        _13_ProductExceptSelf obj = new _13_ProductExceptSelf();

        System.out.println(Arrays.toString(obj.productExceptSelf(new int[]{-1,1,0,-3,3})));
    }
}
