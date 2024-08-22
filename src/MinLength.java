

import java.awt.font.NumericShaper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

class MinLength {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner

        */

        // Write your code here
        Scanner s = new Scanner(System.in);
        int testCase = s.nextInt();                 // Reading input from STDIN

        for(int i=0; i<testCase;i++){
            List<Integer> arr1 = new ArrayList<>();
            List<Integer> arr2 = new ArrayList<>();
            Scanner s2 = new Scanner(System.in);
            int n = s.nextInt();
            for(int j = 0; j < n;j++){
                arr1.add(s.nextInt());
            }
            for(int j = 0; j < n;j++){
                arr2.add(s.nextInt());
            }

            int start = 0;
            int end = n-1;

            for(int k =0; k<n; k++){
                if(Objects.equals(arr1.get(start), arr2.get(start))){
                    start++;
                }
                if(Objects.equals(arr1.get(end), arr2.get(end))){
                    end--;
                }
            }

            System.out.println((end-start)+1);
        }


    }
}
