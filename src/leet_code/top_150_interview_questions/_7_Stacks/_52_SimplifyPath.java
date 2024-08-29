package leet_code.top_150_interview_questions._7_Stacks;

import java.util.Stack;

public class _52_SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int i=0;

        while (i<path.length()){
            String str1 = path.substring(i,i+1);
            if(str1.equals("/")){
                i++;
                continue;
            }
            if(i+2 < path.length()) {
                str1 = path.substring(i, i + 3);
                if (str1.equals("...")) {
                    int index = path.indexOf("/", i);
                    if(index != -1){
                        stack.push(path.substring(i, index));
                        i = index;
                        continue;
                    }
                    stack.push(path.substring(i));
                    break;
                }else if(str1.equals("../")){

                        if (stack.empty()) {
                            i = i + 2;
                            continue;
                        }
                        stack.pop();
                        i = i + 2;
                        continue;
                }

            }else if(i+1<path.length()){
                str1 = path.substring(i, i + 2);
                if (str1.equals("..")) {
                    if (stack.empty()) {
                        i = i + 2;
                        continue;
                    }
                    stack.pop();
                    i = i + 2;
                    continue;
                }
            }

            if(path.startsWith("./", i)){
                i++;
                continue;
            }

            int index = path.indexOf("/",i);
            if(index != -1){
                if(!path.substring(i,index).equals("."))
                    stack.push(path.substring(i, index));
                i = index;
                continue;
            }
            if(!path.substring(i).equals("."))
                stack.push(path.substring(i));
            break;

        }
        if(stack.empty())
            return "/";

        StringBuilder res = new StringBuilder();
        for(String s : stack){
                res.append("/").append(s);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        _52_SimplifyPath ob = new _52_SimplifyPath();
        System.out.println(ob.simplifyPath("/."));
    }
}
