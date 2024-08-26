import java.util.HashMap;
import java.util.Map;

public class _40_ValidAnagram {

    public boolean isAnagramApproach3(String s, String t) {
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

    public boolean isAnagramApproach2(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Integer> wordCount = new HashMap<>();
        for(int i =0; i<s.length(); i++){
            wordCount.put(s.charAt(i), wordCount.getOrDefault(s.charAt(i),0) + 1);
            wordCount.put(t.charAt(i), wordCount.getOrDefault(t.charAt(i),0) - 1);
        }

        for(int i : wordCount.values()){
            if(i!=0){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Integer> wordCount = new HashMap<>();
        for(Character ch : s.toCharArray()){
            wordCount.put(ch, wordCount.getOrDefault(ch,0) + 1);
        }

        Map<Character, Integer> wordCount2 = new HashMap<>();
        int formed=0;
        boolean isStrAnagram = true;
        for(Character ch : t.toCharArray()){
            wordCount2.put(ch, wordCount2.getOrDefault(ch,0) + 1);
            if(wordCount.containsKey(ch)){
                if(wordCount.get(ch).equals(wordCount2.get(ch))){
                    formed++;
                } else if (wordCount2.get(ch)>wordCount.get(ch)) {
                    isStrAnagram = false;
                    break;
                }
            }else {
                isStrAnagram = false;
                break;
            }
        }

        if(formed != wordCount.size()){
            isStrAnagram = false;
        }

        return isStrAnagram;

    }

    public static void main(String[] args) {
        _40_ValidAnagram ob = new _40_ValidAnagram();
        System.out.println(ob.isAnagram("anagram","nagaram"));
    }
}
