public class _10_JumpGame2 {


    Integer []minJumps;
    public int calcMinJumps(int[] nums, int index){
        if(index == nums.length-1){
            return 0;
        }

        if(minJumps[index]!=null){
            return minJumps[index];
        }

        Integer min =null;

        for(int i = 0; i < nums[index]; i++){
            if(index+i+1 <= nums.length-1){
                if(minJumps[index] == null){
                    int temp = 1 + calcMinJumps(nums, index + i + 1);
                    if(min == null)
                        min = temp;
                    else if(min> temp)
                        min = temp;
                }
                else{
                    int temp = minJumps[index];
                    if(min == null)
                        min = temp;
                    else if(min> temp)
                        min = temp;
                }
            }
        }

        if(min != null) {
            minJumps[index] = min;
            return min;
        }


        return 1000000000;
    }

    public int jump(int[] nums) {
        minJumps = new Integer[nums.length];
        return calcMinJumps(nums, 0);
    }

    public static void main(String[] args) {
        _10_JumpGame2 obj = new _10_JumpGame2();

        System.out.println(obj.jump(new int[]{2,3,1,1,4}));
    }
}
