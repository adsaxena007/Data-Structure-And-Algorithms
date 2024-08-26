package leet_code;

public class _28_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }

        int index = 0;
        int k = 0;
        String longestString = "";
        for (String str : strs) {
            if (str.length() > longestString.length()) {
                longestString = str;
                index = k;
            }
            k++;
        }

        String prefix = "";
        for(int i=0; i<= longestString.length(); i++){
            boolean isPrefix = true;
            String subStr = longestString.substring(0, i);
            int j=0;
            for (String str : strs) {
                if(j!=k && !str.startsWith(subStr)) {
                    isPrefix = false;
                    break;
                }
                j++;
            }
            if (isPrefix)
                prefix = longestString.substring(0,i);
        }

        return prefix;
    }

    public static void main(String[] args) {
        _28_LongestCommonPrefix lcp = new _28_LongestCommonPrefix();


        System.out.println(lcp.longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
    }
}
