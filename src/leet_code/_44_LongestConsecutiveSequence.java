package leet_code;

import java.util.HashMap;
import java.util.Map;

public class _44_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;

        if(nums.length==1)
            return 1;


        Map<Integer, Integer> intMatch = new HashMap<>();
        for(int i : nums){
            if(!intMatch.containsKey(i)){
                if(intMatch.containsKey(i+1)){
                    intMatch.put(i+1, i);
                }

                if(intMatch.containsKey(i-1)){
                    intMatch.put(i, i-1);
                }else {
                    intMatch.put(i,null);
                }
            }
        }
        int longestSequence = 1;
        for(int key : intMatch.keySet()){
            if(intMatch.get(key)!=null && !intMatch.containsKey(key+1)){
                int sequence = 1;
                Integer currentKey = intMatch.get(key);
                while(currentKey!=null){
                    currentKey = intMatch.get(currentKey);
                    sequence++;
                }
                longestSequence = Math.max(longestSequence, sequence);
            }
        }

        return longestSequence;
    }

    public static void main(String[] args) {
        _44_LongestConsecutiveSequence ob = new _44_LongestConsecutiveSequence();
        System.out.println(ob.longestConsecutive(new int[]{100,200,4,3,1,2}));

    }
}
