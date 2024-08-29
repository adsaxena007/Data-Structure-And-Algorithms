package leet_code.top_150_interview_questions._7_Stacks;

import java.util.Stack;

public class _55_BasicCalculator {

    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        s = s.replaceAll(" ", "");
        int i=0;
        while(i<s.length()){
            if(s.charAt(i) != ')' ){
                if(s.charAt(i) =='+' || s.charAt(i) == '-' || s.charAt(i) == '('){
                    stack.push(s.charAt(i)+"");
                    i++;
                    continue;
                }
                int temp = i;
                while(temp<s.length() && s.charAt(temp) !='+' && s.charAt(temp) != '-' && s.charAt(temp) != '(' && s.charAt(temp) != ')'){
                    temp++;
                }
                if(temp<s.length())
                    stack.push(s.substring(i,temp));
                else
                    stack.push(s.substring(i));
                i = temp;
                continue;
            }

            if(s.charAt(i)==')'){
                while (true){
                    int var1 = Integer.parseInt(stack.pop());
                    String operator = stack.pop();
                    if(operator.equals("(")){
                        stack.push(String.valueOf(var1));
                        break;
                    }
                    String op1 = stack.peek();
                    if(op1.equals("(")){
                        stack.pop();
                        if(operator.equals("+"))
                            stack.push(String.valueOf(var1));
                        else
                            stack.push(String.valueOf(-var1));

                        break;
                    }
                    int var2 = Integer.parseInt(stack.pop());
                    String op = stack.peek();
                    int result = 0;
                    if(operator.equals("+") && (op.equals("+") || op.equals("("))){
                        result = var1+var2;
                    }else if(operator.equals("+") && op.equals("-")){
                        stack.pop();
                        stack.push("+");
                        result = var1 - var2;
                    } else if(operator.equals("-") && (op.equals("+") || op.equals("("))) {
                        result = var2-var1;
                    }else if(operator.equals("-") && op.equals("-")){
                        stack.pop();
                        stack.push("+");
                        result =  -var2 - var1;
                    }

                    if(op.equals("(")){
                        stack.pop();
                        stack.push(String.valueOf(result));
                        break;
                    }
                    stack.push(String.valueOf(result));
                }
            }
            i++;
        }

        int result=0;
        while (true){
            int var1 = Integer.parseInt(stack.pop());
            if(stack.empty()){
                result = var1;
                break;
            }

            String operator = stack.pop();
            if(stack.empty()){
                if(operator.equals("-"))
                    result = -var1;
                else
                    result = var1;
                break;
            }
            int var2 = Integer.parseInt(stack.pop());
            if(!stack.empty()){
                String op = stack.peek();
                if(operator.equals("+") && op.equals("+")){
                    result = var1+var2;
                }else if(operator.equals("+") && op.equals("-")){
                    stack.pop();
                    stack.push("+");
                    result = var1 - var2;
                } else if(operator.equals("-") && op.equals("+")){
                    result = var2-var1;
                }else if(operator.equals("-") && op.equals("-")){
                    stack.pop();
                    stack.push("+");
                    result =  -var2 - var1;
                }
            }else {
                if(operator.equals("+")){
                    result = var1+var2;
                }else {
                    result = var2-var1;
                }
            }
            if(stack.empty()){
                break;
            }
            stack.push(String.valueOf(result));
        }


        return result;
    }

    public static void main(String[] args) {
        _55_BasicCalculator ob = new _55_BasicCalculator();

        System.out.println(ob.calculate("-2+ 1"));
    }
}
