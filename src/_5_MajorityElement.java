import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class _5_MajorityElement {
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(nums).forEach(el->{
            if(map.containsKey(el)){
                int count = map.get(el);
                map.put(el,++count);
            }else {
                map.put(el,1);
            }
        });

        AtomicInteger maxCount = new AtomicInteger(map.get(nums[0]));
        AtomicInteger majorityElement = new AtomicInteger(nums[0]);
        map.forEach((key,value)->{
            if(value > maxCount.get()){
                maxCount.set(value);
                majorityElement.set(key);
            }
        });

        return majorityElement.get();
    }
}
