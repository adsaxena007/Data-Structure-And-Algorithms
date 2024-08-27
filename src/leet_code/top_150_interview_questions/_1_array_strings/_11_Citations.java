package leet_code.top_150_interview_questions._1_array_strings;

import java.util.Arrays;

public class _11_Citations {
    public int hIndex(int[] citations) {
        if(citations.length == 1 && citations[0] == 0){
            return 0;
        } else if (citations.length == 1 && citations[0] > 0) {
            return 1;
        }
        Arrays.sort(citations);
        if(citations.length <= citations[0])
            return citations.length;

        for(int i=citations.length-1; i>=0; i--){

            int hIndexCandidate = citations.length - i; // Candidate H-index
            if (citations[i] >= hIndexCandidate && (i == 0 || citations[i - 1] <= hIndexCandidate)) {
                return hIndexCandidate;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        _11_Citations obj = new _11_Citations();
        System.out.println(obj.hIndex(new int[]{4,4,0,0}));;
    }
}
