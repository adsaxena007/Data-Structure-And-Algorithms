import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class _39_WordPattern {
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
        _39_WordPattern ob = new _39_WordPattern();
        System.out.println(ob.wordPattern("abba","dog cat cat fish"));
    }
}
