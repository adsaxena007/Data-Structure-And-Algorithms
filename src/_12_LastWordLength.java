import java.util.Arrays;

public class _12_LastWordLength {
    public int lengthOfLastWord(String s) {
        String [] str = s.split(" ");
        return str[str.length-1].length();
    }
}
