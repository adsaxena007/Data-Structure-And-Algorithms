package leet_code;

public class _21_MissingNumber {
    public int missingNumber(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        for(int el : nums){
            if(el>max)
                max = el;

            if(el<min)
                min = el;
        }

        for(int i=min+1; i<max-1; i++){
            boolean found =false;
            for(int el : nums){
                if(el == i){
                    found = true;
                }
            }
            if(!found)
                return i;
        }
        return 0;
    }
}
