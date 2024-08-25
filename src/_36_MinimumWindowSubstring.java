import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _36_MinimumWindowSubstring {
    Map<Character, Integer> wordCount;

    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";

        if(t.length() == s.length() && s.equals(t)){
            return s;
        }

        wordCount = new HashMap<>();
        int minWindow = Integer.MAX_VALUE;
        int resultLeft =0;
        int resultRight =0;
        int left = 0;
        int right = left;
        boolean isFound = false;
        for(Character ch : t.toCharArray()){
            wordCount.put(ch, wordCount.getOrDefault(ch,0) + 1);
        }
        Map<Character, Integer> currentMap = new HashMap<>();
        int formed= 0;
        while(left<=right && right<s.length()){
            if (!wordCount.containsKey(s.charAt(right))){
                right++;
                continue;
            }
            Character key = s.charAt(right);

            currentMap.put(key, currentMap.getOrDefault(key,0)+1);

            if(Objects.equals(currentMap.get(key), wordCount.get(key))){
                formed++;
            }


            while(left<right){
                Character leftChar = s.charAt(left);
                if(currentMap.containsKey(leftChar) && currentMap.get(leftChar)-1 >= wordCount.get(leftChar)){
                    currentMap.put(leftChar, currentMap.get(leftChar)-1);
                } else if(currentMap.containsKey(leftChar) && currentMap.get(leftChar)-1 < wordCount.get(leftChar)){
                    break;
                }
                left++;
            }


            boolean isWindowCorrect = formed == wordCount.size();

            if(isWindowCorrect){
                int length = right-left+1;
                if(length < minWindow){
                    minWindow = length;
                    resultRight = right;
                    resultLeft = left;
                    isFound = true;
                }
            }
            right++;
        }
        return isFound ? s.substring(resultLeft,resultRight+1) : "";
    }

    public static void main(String[] args) {
        _36_MinimumWindowSubstring ob = new _36_MinimumWindowSubstring();
        System.out.println(ob.minWindow("ADOBECODEBANC","ABC"));
        System.out.println(ob.minWindow("aaaaaaaaaaaabbbbbcdd","abcdd"));
    }
}
