package leet_code.top_150_interview_questions._1_array_strings;

public class _1_mergeSortedArray {


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i=0;
        int j=0;
        int k=0;
        int []list = new int[m+n];

        while(i<m || j<n){
            if(i<m && j<n){
                if(nums1[i]<=nums2[j]){
                    list[k]=nums1[i];
                    i++;
                    k++;
                }else {
                    list[k]=nums2[j];
                    j++;
                    k++;
                }
            }

            if(i<m && j>=n){
                list[k]=nums1[i];
                i++;
                k++;
            }

            if(i>=m && j<n){
                list[k]=nums2[j];
                j++;
                k++;
            }
        }

        for(i=0;i< list.length;i++){
            nums1[i] = list[i];
        }
        list=null;
    }

    public void twoPointerMerge(int[] nums1, int m, int[] nums2, int n) {

    }
}