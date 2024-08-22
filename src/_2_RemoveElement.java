public class _2_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int count=0;

        for(int i=0; i<nums.length; i++){

            if(nums[i]==val){
                count++;
                int j=i;
                for(;j<nums.length-1;j++){
                    nums[j]=nums[j+1];
                }
                nums[j]=-1;
                i--;
            }
        }

        return nums.length-count;
    }
    public static void main(String[] args) {
        _2_RemoveElement obj = new _2_RemoveElement();

        obj.removeElement(new int[]{4,4,0,1,0,2},0);
    }
}
