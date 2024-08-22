import java.util.Arrays;

public class _4_RemoveDuplicatesAtMostTwice {
    public int removeDuplicates(int[] nums) {

        int i=0;
        int j =i+1;
        int current = nums[0];
        for(;j<nums.length;j++){
            if(nums[j]==current){
                if(i==0){
                    i++;
                    continue;
                }
                if(nums[i] == current && nums[i-1] != current && nums[j] == current){
                    i++;
                    nums[i]=nums[j];
                    continue;
                }
                if(nums[i] == current && nums[i-1] == current && nums[j] == current){
                    continue;
                }
                if(nums[i] == current && nums[i-1] == current && nums[j] != current){
                    i++;
                    nums[i]=nums[j];
                    current=nums[j];
                }
            }else {
                i++;
                nums[i]=nums[j];
                current=nums[j];
            }
        }

        Arrays.stream(nums).forEach(System.out::print);
        return i;
    }

    public static void main(String[] args) {
        _4_RemoveDuplicatesAtMostTwice obj = new _4_RemoveDuplicatesAtMostTwice();

        int count =obj.removeDuplicates(new int[]{0,0,1,1,1,1,2,2,3});
        System.out.println();
        System.out.println(count);
    }
}