import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _20_MinimumWindowSubstring {

    Map<Character, Integer> map;
    public String minWindow(String s, String t) {
        map = new HashMap<>();
        List<String> subStrings = new ArrayList<>();
        for(int i = 0 ;i<t.length(); i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                map.put(ch,++count);
            }else{
                map.put(ch,1);
            }
        }

        int left = 0;
        int right = 0;
        // DOBECODEBANC
        for(int i = 0 ;i<s.length(); i++){
          StringBuilder sb = new StringBuilder();
          char ch = s.charAt(i);

          if(map.containsKey(ch)){
              int count = map.get(ch);
              map.put(ch,--count);
              right++;
          }else{
              left++;
              right++;
          }



            String as = "s";

        }


        return "";
    }
}
