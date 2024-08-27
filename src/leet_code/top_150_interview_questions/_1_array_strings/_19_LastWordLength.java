package leet_code.top_150_interview_questions._1_array_strings;

public class _19_LastWordLength {
    public int lengthOfLastWord(String s) {
        String [] str = s.split(" ");
        return str[str.length-1].length();
    }
}
