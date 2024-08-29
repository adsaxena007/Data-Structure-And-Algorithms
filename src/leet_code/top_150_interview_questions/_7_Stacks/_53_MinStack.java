package leet_code.top_150_interview_questions._7_Stacks;


import java.util.*;

class MinStack {
    private Integer min;
    private final Stack<Integer> stack;
    private final SortedSet<Integer> set;
    private final HashMap<Integer,Integer> map;
    public MinStack() {
        stack = new Stack<>();
        set = new TreeSet<>();
        map = new HashMap<>();
    }

    public void push(int val) {
        stack.push(val);
        set.add(val);
        map.put(val, map.getOrDefault(val,0) +1);
        min = set.first();
    }

    public void pop() {
        int el = stack.pop();

        if(map.containsKey(el)){
            int count = map.get(el)-1;

            if (count==0){
                set.remove(el);
                map.remove(el);
                if(stack.empty()){
                    min = null;
                    return;
                }
                min = set.first();
            }else {
                map.put(el,  count);
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
public class _53_MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}
