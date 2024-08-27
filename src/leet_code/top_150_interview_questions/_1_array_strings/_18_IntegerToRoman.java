package leet_code.top_150_interview_questions._1_array_strings;

import java.util.HashMap;
import java.util.Map;

public class _18_IntegerToRoman {

    Map<Integer, String> map;
    public String convert(int num){
        int[] arr = new int[]{1000,500,100,50,10,5,1};
        int i=0;
        int tempNum=0;
        String result="";
        while (i<arr.length){
            if(tempNum + arr[i] < num){
                tempNum = tempNum+arr[i];
                result = result + map.get(arr[i]);
            }else if( tempNum + arr[i] == num) {
                result = result + map.get(arr[i]);
                break;
            }else{
                i++;
            }
        }
        return result;
    }

    public String intToRoman(int num) {
        map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        StringBuilder res= new StringBuilder("");
        int i=1;
        while (num>0){
            int digit = num%10;
            if(map.containsKey(digit * i)){
                res = new StringBuilder(map.get(digit * i) + res);

            } else{
                res  = new StringBuilder(convert(digit * i) + res);
            }
            i = i*10;
            num = (int)Math.floor((double) num /10);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        _18_IntegerToRoman obj= new _18_IntegerToRoman();

        System.out.println(obj.intToRoman(3749));
    }
}
