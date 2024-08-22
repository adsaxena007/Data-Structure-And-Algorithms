public class _15_IsSubsequence {
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
        _15_IsSubsequence obj = new _15_IsSubsequence();
        System.out.println(obj.isSubsequence("axc", "ahbgdc"));
    }
}
