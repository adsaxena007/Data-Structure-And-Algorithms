import java.util.HashMap;
import java.util.Map;

public class _25_TrappingRainWater {

    public int trap(int[] height) {
        int left = 0;
        int right = 1;
        int waterCount = 0;
        int intermediateObs=0;
        Map<String, Boolean> memo = new HashMap<>();
        for(int i = 0; i < height.length; i++){
            if(i!=left && i!=right){
                intermediateObs = intermediateObs + height[i];
            }
            if(right<height.length){
                if(height[left] <= height[right]){
                    if(!memo.containsKey(left + "" +right)) {
                        waterCount = waterCount + (((right-left-1)*height[left]) - intermediateObs);
                        memo.put(left + "" +right, true);
                    }
                    left=right;
                    right++;
                    intermediateObs=0;
                    continue;
                }
                if(height[left] > height[right]){
                    right++;
                }
            }
        }

        left = height.length-2;
        right = height.length-1;
        intermediateObs=0;

        for(int i = height.length-1; i >=0; i--){
            if(i!=left && i!=right){
                intermediateObs = intermediateObs + height[i];
            }
            if(left>=0){
                if(height[left] >= height[right]){
                    if(!memo.containsKey(left + "" +right)) {
                        waterCount = waterCount + (((right - left - 1) * height[right]) - intermediateObs);
                        memo.put(left + "" +right, true);
                    }
                    right=left;
                    left--;
                    intermediateObs=0;
                    continue;
                }
                if(height[left] < height[right]){
                    left--;
                }
            }
        }
        return waterCount;
    }
}
