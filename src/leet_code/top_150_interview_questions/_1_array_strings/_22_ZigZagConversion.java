package leet_code.top_150_interview_questions._1_array_strings;

public class _22_ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;

        String [][] matrix = new String [numRows][s.length()];

        int i=0, j=0, k=0;
        boolean reached=false;
        while(i>=0 && i<numRows && j>=0 && j<s.length() && k<s.length()){
            if(reached){
                matrix[i][j] = s.substring(k,k+1);
                if(i==0) {
                    reached = false;
                    i++;
                    k++;
                    continue;
                }
                i--;
                k++;
                j++;
            }

            if(!reached && k<s.length()){
                matrix[i][j] = s.substring(k,k+1);
                if(i==numRows-1) {
                    reached = true;
                    i--;
                    j++;
                    k++;
                    continue;
                }
                i++;
                k++;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int l=0;l<numRows; l++){
            for(int m=0;m<s.length();m++){
                if(matrix[l][m]==null){
                    continue;
                }
                result.append(matrix[l][m]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        _22_ZigZagConversion zc = new _22_ZigZagConversion();
        System.out.println(zc.convert("PAYPALISHIRING", 4));
        zc.convert("vucftpwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwltwjwnnvbwjckdmeouuzhyvhgvwujbqxxpitcvograiddvhrrdsycqhkleewhxtembaqwqwpqhsuebnvfgvjwdvjjafqzzxlcxdzncqgjlapopkvxfgvicetcmkbljopgtqvvhbgsdvivhesnkqxmwrqidrvmhlubbryktheyentmrobdeyqcrgluaiihveix", 247);
//
//        zc.convert("A", 1);
//        zc.convert("AB", 1);
//        zc.convert("ABCD", 2);
    }
}
