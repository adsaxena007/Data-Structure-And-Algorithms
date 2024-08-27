package leet_code.top_150_interview_questions._1_array_strings;

public class _9_JumpGame {
    boolean reachedEnd = false;
    Boolean[] visited;
    public boolean jump(int[] nums, int index){
        if(index == nums.length-1){
            return true;
        }

        if(nums[index] == 0){
            return false;
        }

        for(int i = 1; i<=nums[index];i++){
            if(index+i<nums.length){
                if (visited[index + i] == null) {
                    visited[index + i] = jump(nums, index + i);
                }
                reachedEnd =  reachedEnd || visited[index+i];
                if(reachedEnd){
                    return true;
                }
            }
        }
        return reachedEnd;
    }

    public boolean canJump(int[] nums) {
        visited = new Boolean[nums.length];
        reachedEnd = false;
        return jump(nums, 0);
    }

    public static void main(String[] args) {
        _9_JumpGame obj = new _9_JumpGame();

        System.out.println(obj.canJump(new int[]{2,0,0}));
    }
}
