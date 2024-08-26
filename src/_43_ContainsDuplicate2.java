import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _43_ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> numCount = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(numCount.containsKey(nums[i])){
                List<Integer> t = numCount.get(nums[i]);
                t.add(i);
                numCount.put(nums[i], t);
            }else {
                List<Integer> t = new ArrayList<>();
                t.add(i);
                numCount.put(nums[i], t);
            }
        }

        for(Integer i : numCount.keySet()){
            List<Integer> indexList =numCount.get(i);
            if(indexList.size()>1){
                for(int currentIndex:  indexList){
                    for(int l=1;l<=k;l++){
                        if(indexList.contains(currentIndex + l)){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        _43_ContainsDuplicate2 ob =new _43_ContainsDuplicate2();
        System.out.println(ob.containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
    }
}
