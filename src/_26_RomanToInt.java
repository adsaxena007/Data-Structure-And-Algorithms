import java.util.HashMap;
import java.util.Map;

public class _26_RomanToInt {
    Map<String, Integer> memo;
    public int romanToInt(String s) {
        memo = new HashMap<>();
        memo.put("I",1);
        memo.put("V",5);
        memo.put("X",10);
        memo.put("L",50);
        memo.put("C",100);
        memo.put("D",500);
        memo.put("M",1000);
        memo.put("IV",4);
        memo.put("IX",9);
        memo.put("XL",40);
        memo.put("XC",90);
        memo.put("CD",400);
        memo.put("CM", 900);

        int number =0;
        for(int i =0;i<s.length();i++){
            String str="";
            if(i+1<s.length()){
                str = s.substring(i,i+2);
                if(memo.containsKey(str)){
                    number=number+memo.get(str);
                    i++;
                    continue;
                }
            }
            str = s.substring(i,i+1);
            if(memo.containsKey(str)){
                number=number+memo.get(str);
                continue;
            }
        }
        return number;
    }
}
