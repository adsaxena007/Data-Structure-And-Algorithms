package leet_code.top_150_interview_questions._5_hash_map;

import java.util.HashMap;
import java.util.Map;

public class _39_RansomNote {

    Map<Character, Integer> wordCount;
    public boolean canConstruct(String ransomNote, String magazine) {
        wordCount = new HashMap<>();
        for(Character ch : ransomNote.toCharArray()){
            wordCount.put(ch, wordCount.getOrDefault(ch,0) + 1);
        }
        Map<Character, Integer> currentMap = new HashMap<>();
        int formed = 0;
        int i = 0;
        boolean canBeConstructed = false;
        while(i<magazine.length()){
            Character key = magazine.charAt(i);
            if(wordCount.containsKey(key)){
                currentMap.put(key, currentMap.getOrDefault(key,0) + 1);
                if(currentMap.get(key).equals(wordCount.get(key))){
                    formed++;
                }
            }

            if(formed == wordCount.size()){
                canBeConstructed = true;
                break;
            }
            i++;
        }
        return canBeConstructed;
    }

    public static void main(String[] args) {
        _39_RansomNote ob = new _39_RansomNote();
        System.out.println(ob.canConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
