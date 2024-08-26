package leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _41_GroupAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int [] charCount = new int[26];
        for(int i =0; i<s.length(); i++){
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for(int i : charCount){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result2 = new HashMap<>();
        boolean [] added = new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            if(added[i]){
                continue;
            }
            if(!result2.containsKey(strs[i])){
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                result2.put(strs[i], temp);
                added[i] = true;
            }
            for(int j=i+1;j<strs.length;j++){
                if(isAnagram(strs[i], strs[j])){
                    if(result2.containsKey(strs[i])){
                        List<String> temp = result2.get(strs[i]);
                        temp.add(strs[j]);
                        added[j] = true;
                        result2.put(strs[i], temp) ;
                    }
                }
            }
        }
        return result2.values().stream().toList();
    }

}
