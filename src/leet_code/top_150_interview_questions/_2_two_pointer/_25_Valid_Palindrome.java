package leet_code.top_150_interview_questions._2_two_pointer;

public class _25_Valid_Palindrome {
    public boolean isPalindrome(String s) {

        s = s.trim().toLowerCase();
        StringBuilder str = new StringBuilder();
        char [] ch = s.toCharArray();


        for(int i = 0 ; i < ch.length; i++){
            if(ch[i] >= 97 && ch[i] <= 122 || ((int)ch[i] >= '0' && (int)ch[i] <= '9'))
                str.append(ch[i]);
        }
        if(str.toString().isEmpty() || str.length() ==1)
            return true;

        int start = 0;
        int end = str.length()-1;


        for(int i = 0; i < str.length(); i++){
            if(str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            }
        }
        return start == str.length() && end == -1;
    }

    public static void main(String[] args) {
        _25_Valid_Palindrome obj = new _25_Valid_Palindrome();
        System.out.println(obj.isPalindrome("0P"));
    }
}
