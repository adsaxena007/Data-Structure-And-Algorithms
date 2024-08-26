package leet_code;

public class _3_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {

        int i=0;
        int j =i+1;

        for(;j<nums.length;j++){
            if(nums[i]==nums[j]){
                continue;
            }else {
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        _3_RemoveDuplicates obj = new _3_RemoveDuplicates();

        int count =obj.removeDuplicates(new int[]{1,1,2});
    }
}