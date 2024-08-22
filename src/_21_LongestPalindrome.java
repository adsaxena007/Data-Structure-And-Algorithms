import java.util.Arrays;

public class _21_LongestPalindrome {
    private Boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    Boolean [][] memoString;
    String [][] memoResult;
    public String getLongestPalindrome(String s, int start, int end, String substr) {
        if (start >= s.length() || end > s.length()) {
            return substr;
        }

        if(memoResult[start][end-1] != null){
            return memoResult[start][end-1];
        }

        String substring = s.substring(start,end);

        if(memoString[start][end-1] == null){
            memoString[start][end-1] = isPalindrome(substring);
        }

        if(memoString[start][end-1] && substring.length() >= substr.length()){
            substr = substring;
        }

        String str1 = getLongestPalindrome(s, start, end + 1, substr);
        String str2 = getLongestPalindrome(s, start + 1, end + 1, substr);
        memoResult[start][end-1]  = (str1.length() >= str2.length()) ? str1 : str2;

        return memoResult[start][end-1];
    }

    public String longestPalindrome(String s) {
        memoString = new Boolean[s.length()][s.length()];
        memoResult = new String[s.length()][s.length()];
        return getLongestPalindrome(s, 0,1, "");
    }

    public static void main(String[] args) {
        _21_LongestPalindrome obj = new _21_LongestPalindrome();
        System.out.println(obj.longestPalindrome("abcdbbfcba"));

    }
}
