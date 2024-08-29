package leet_code.top_150_interview_questions._6_intervals;

import java.util.ArrayList;
import java.util.List;

public class _48_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length == 0)
            return result;

        if(nums.length == 1){
            result.add(nums[0] + "");
            return result;
        }

        StringBuilder str = new StringBuilder();
        int index = 0;
        int temp = nums[0];
        str.append(temp);
        for(int i=1;i<nums.length;i++){
            if(nums[i] == temp+1){
                temp++;
                if(i+1 == nums.length) {
                    str.append("->").append(temp);
                    result.add(str.toString());
                }
                continue;
            }else {
                if(i-1 != index){
                    str.append("->").append(temp);
                }
                result.add(str.toString());
                str = new StringBuilder();
                index = i;
                str.append(nums[i]);
                temp = nums[i];
                if(i+1 == nums.length)
                    result.add(str.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _48_SummaryRanges ob = new _48_SummaryRanges();
//        System.out.println(ob.summaryRanges(new int[]{0,2,3,4,6,8,9}));
        System.out.println(ob.summaryRanges(new int[]{-1}));

    }
}
