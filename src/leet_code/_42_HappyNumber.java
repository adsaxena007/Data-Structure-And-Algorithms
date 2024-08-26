package leet_code;

import java.util.ArrayList;
import java.util.List;

public class _42_HappyNumber {

    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n);
        while(true){
            int temp = n;
            int sum=0;
            while (temp!=0){
                int digit = temp%10;
                sum = sum + (digit*digit);
                temp = temp/10;
            }
            n=sum;
            if(list.contains(n)){
                break;
            }
            list.add(n);
            System.out.println(sum);
        }

        return n==1;

    }

    public static void main(String[] args) {
        _42_HappyNumber ob =new _42_HappyNumber();
        ob.isHappy(2);
    }
}
