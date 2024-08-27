package leet_code.top_150_interview_questions._1_array_strings;

public class _23_FirstOccurrence {

    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle))
            return -1;

        if(haystack.equals(needle))
            return 0;

        int i=0;
        while(i<(haystack.length())){
            if(haystack.substring(i,i+1).equals(needle.substring(0,1)) && haystack.startsWith(needle, i)){
                return i;
            }
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        _23_FirstOccurrence fo = new _23_FirstOccurrence();
        System.out.println(fo.strStr("abc", "c"));
    }
}
