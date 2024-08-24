import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _35_SubstringWithConcatenationOfAllWords {
    Map<String, Integer> map;

    public void createMap(String[] words){
        map = new HashMap<>();
        for(String word : words){
            if(map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }else {
                map.put(word,1);
            }
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int minWindow = wordLen * words.length;
        int left = 0;
        int right = left + minWindow;
        List<Integer> result = new ArrayList<>();

        if(minWindow>s.length())
            return result;

        createMap(words);
        while (right<=s.length()){
            String temp = s.substring(left,right);
            boolean isConcatenatedString = true;

            while(!temp.isEmpty()){
                String str = temp.substring(0,wordLen);
                temp = temp.substring(wordLen);

                if(map.containsKey(str)){
                    int count = map.get(str);
                    if(count==1){
                        map.remove(str);
                    }else {
                        map.put(str, map.get(str)-1);
                    }
                } else {
                    isConcatenatedString = false;
                    break;
                }
            }

            if(isConcatenatedString){
                result.add(left);
            }

            if(right==s.length())
                break;

            createMap(words);

            if(right+wordLen>s.length()){
                left++;
                right++;
                continue;
            }


            while (right<=s.length()){
                if(isConcatenatedString & left+1<s.length() && right+1<s.length() && s.substring(left,right).equals(s.substring(left+1,right+1))){
                    left++;
                    right++;
                    result.add(left);
                    continue;
                }

                if(isConcatenatedString && left+wordLen<=s.length() && right+wordLen<=s.length() && s.substring(left,left+wordLen).equals(s.substring(right,right+wordLen))){
                    left = left + wordLen;
                    right = left + minWindow;
                    result.add(left);
                    continue;
                }
                left++;
                while (left+minWindow<s.length()){
                    String key = s.substring(left, left+wordLen);
                    if(!map.containsKey(key)){
                        left++;
                        continue;
                    }
                    break;
                }
                right = left+minWindow;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _35_SubstringWithConcatenationOfAllWords ob = new _35_SubstringWithConcatenationOfAllWords();

        System.out.println(ob.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
        System.out.println(ob.findSubstring("ababaab", new String[]{"ab","ba","ba"}));
        System.out.println(ob.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
        System.out.println(ob.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
        System.out.println(ob.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}));
        System.out.println(ob.findSubstring("abaababbaba", new String[]{"ab","ba","ab","ba"}));
    }
}


