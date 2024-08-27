package leet_code.top_150_interview_questions._2_two_pointer;

public class _26_IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        if(s.isEmpty())
            return true;

        if(t.isEmpty())
            return false;

        int start =0;
        for(int i=0; i< t.length();i++){
            if(t.charAt(i) == s.charAt(start)){
                start++;
            }
            if(start == s.length()){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        _26_IsSubsequence obj = new _26_IsSubsequence();
        System.out.println(obj.isSubsequence("axc", "ahbgdc"));
    }
}
