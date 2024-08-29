package leet_code.top_150_interview_questions._7_Stacks;

import java.util.List;
import java.util.Stack;

public class _51_ValidParentheses {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(Character ch : s.toCharArray()){
            if(ch.equals('{') || ch.equals('[') || ch.equals('(')){
                stack.push(ch);
            }else {
                if(stack.empty()){
                    return false;
                }
                Character temp = stack.pop();

                if(temp.equals('{') && ch.equals('}')){
                    continue;
                }
                if(temp.equals('[') && ch.equals(']')){
                    continue;
                }
                if(temp.equals('(') && ch.equals(')')){
                    continue;
                }
                return false;
            }
        }
        return stack.empty();
    }
}
