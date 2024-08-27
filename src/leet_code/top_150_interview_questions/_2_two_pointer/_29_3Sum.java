package leet_code.top_150_interview_questions._2_two_pointer;

import java.util.*;

public class _29_3Sum {


    Map<String ,List<Integer>> result;

    public int [] getTwoSum(int[] nums, int target, int thirdIndex){
        int start = 0;
        int end = nums.length-1;

        for(int i = 0 ; i<nums.length;i++){
            if(i == thirdIndex) {
                if(start == thirdIndex)
                    start++;
                if(end == thirdIndex)
                    end--;

                continue;
            }


            if(nums[start] + nums[end] == target){
                if(nums[start]>=nums[end])
                    return new int [] {nums[end], nums[start]};
                else
                    return new int [] {nums[start], nums[end]};
            }

            if(nums[start] + nums[end] <= target){
                start++;
            }
            if(nums[start] + nums[end] > target){
                end--;
            }
        }
        return new int [] {-1};

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        result = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int a = nums[i];
            int [] rem = getTwoSum(nums, -a, i);
            if(rem.length==2){
                if(a+rem[0]+rem[1]==0){
                    List<Integer> l = new ArrayList<>();
                    StringBuilder s = new StringBuilder();
                    if(a<=rem[0]){
                        l.add(a);
                        l.add(rem[0]);
                        l.add(rem[1]);

                        s.append(a);
                        s.append(rem[0]);
                        s.append(rem[1]);
                    }
                    if(a>rem[0] && a<rem[1]){
                        l.add(rem[0]);
                        l.add(a);
                        l.add(rem[1]);

                        s.append(rem[0]);
                        s.append(a);
                        s.append(rem[1]);
                    }

                    if(a>rem[1]){
                        l.add(rem[0]);
                        l.add(rem[1]);
                        l.add(a);

                        s.append(rem[0]);
                        s.append(rem[1]);
                        s.append(a);
                    }
                    if(!l.isEmpty())
                        result.put(s.toString(), l);
                }
            }
        }
        return result.values().stream().toList();
    }

    public static void main(String[] args) {
        _29_3Sum obj = new _29_3Sum();
        _29_3Sum obj1 = new _29_3Sum();
//        String s = "11321";
        System.out.println(obj.hashCode()%8);
//        System.out.println(obj.threeSum(new int[]{1,2,-2,-1}));;
    }
}
