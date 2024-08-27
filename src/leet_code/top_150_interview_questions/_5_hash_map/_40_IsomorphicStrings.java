package leet_code.top_150_interview_questions._5_hash_map;

import java.util.LinkedHashMap;
import java.util.Map;

public class _40_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> wordMatch = new LinkedHashMap<>();
        int i=0;
        StringBuilder result = new StringBuilder();
        for(Character ch : s.toCharArray()){
            if(!wordMatch.containsKey(ch)){
                if(wordMatch.containsValue(t.charAt(i))){
                    break;
                }
                wordMatch.put(ch, t.charAt(i));
            }
            result.append(wordMatch.get(ch));
            i++;
        }




        return result.toString().equals(t);
    }
}
