package leet_code.top_150_interview_questions._7_Stacks;

import java.util.Stack;

public class _54_EvaluatePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String ch : tokens){
            if(!ch.equals("+") && !ch.equals("-") && !ch.equals("*") && !ch.equals("/")){
                stack.push(Integer.parseInt(ch));
                continue;
            }

            if(ch.equals("+")){
                int var1 = stack.pop();
                int var2 = stack.pop();
                stack.push(var1+var2);
                continue;
            }
            if(ch.equals("-")){
                int var1 = stack.pop();
                int var2 = stack.pop();
                stack.push(var2-var1);
            }

            if(ch.equals("*")){
                int var1 = stack.pop();
                int var2 = stack.pop();
                stack.push(var1*var2);
            }

            if(ch.equals("/")){
                int var1 = stack.pop();
                int var2 = stack.pop();
                stack.push(var2/var1);
            }


        }
        return stack.pop();
    }
}
