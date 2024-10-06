package leet_code.top_150_interview_questions._14_backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _105_LetterCombinationsOfPhoneNumber {
    Map<Character, List<Character>> map;
    List<String> result;
    public void backtrack(String digits, int i, String str){
        if(i > digits.length())
            return;

        if(i == digits.length() && !result.contains(str)){
            result.add(str);
            return;
        }


        for(Character ch : map.getOrDefault(digits.charAt(i), new ArrayList<>()))
            backtrack(digits, i + 1, str + ch);
    }

    public List<String> letterCombinations(String digits) {

        if(digits.isEmpty())
            return new ArrayList<>();

        map = new HashMap<>();
        map.put('2',List.of('a','b','c'));
        map.put('3',List.of('d','e','f'));
        map.put('4',List.of('g','h','i'));
        map.put('5',List.of('j','k','l'));
        map.put('6',List.of('m','n','o'));
        map.put('7',List.of('p','q','r', 's'));
        map.put('8',List.of('t','u','v'));
        map.put('9',List.of('w','x','y', 'z'));
        result = new ArrayList<>();

        backtrack(digits, 0, "");

        return result;
    }

    public static void main(String[] args) {
        _105_LetterCombinationsOfPhoneNumber ob = new _105_LetterCombinationsOfPhoneNumber();

        System.out.println(ob.letterCombinations("23"));
    }
}
