package leet_code.top_150_interview_questions._5_hash_map;

import java.util.HashMap;
import java.util.Map;

public class _41_WordPattern {
    public boolean wordPattern(String pattern, String s) {

        Map<String, Character> wordMatch = new HashMap<>();

        int i=0;
        StringBuilder result = new StringBuilder();
        String strArr[] = s.split(" ");
        if(pattern.length() != strArr.length)
            return false;
        boolean isPattern = true;
        while(i<strArr.length){
            for(Character ch : pattern.toCharArray()){
                if(i<strArr.length){
                    if(!wordMatch.containsKey(strArr[i])){
                        if(wordMatch.containsValue(ch)){
                            isPattern = false;
                            break;
                        }
                        wordMatch.put(strArr[i], ch);
                    }
                    result.append(wordMatch.get(strArr[i]));
                }
               i++;
            }
            if(!isPattern)
                break;
        }
        return result.toString().replaceAll(pattern, "").isEmpty();
    }

    public static void main(String[] args) {
        _41_WordPattern ob = new _41_WordPattern();
        System.out.println(ob.wordPattern("abba","dog cat cat fish"));
    }
}
