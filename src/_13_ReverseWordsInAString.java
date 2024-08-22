public class _13_ReverseWordsInAString {
    public String reverseWords(String s) {
        String [] str = s.trim().split( " ");
        StringBuilder result = new StringBuilder();
        for(int i = str.length-1; i>=0; i--){
            if(!str[i].isEmpty()) {
                result.append(str[i].trim());
                if (i > 0)
                    result.append(" ");
            }
        }


        return result.toString();
    }

    public static void main(String[] args) {
        _13_ReverseWordsInAString obj = new _13_ReverseWordsInAString();
        System.out.println(obj.reverseWords("a good   example"));
    }
}
