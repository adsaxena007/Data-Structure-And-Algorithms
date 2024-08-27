package leet_code;

import java.util.ArrayList;
import java.util.List;

public class _46_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i=0, j=0;
        int m= matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        boolean [][] visited = new boolean[m][n];
        int k = 0;
        int temp = Math.max(n,m);
        while(k<temp){
            while (j<n){
                if(!visited[i][j])
                    result.add(matrix[i][j]);
                visited[i][j] = true;
                j++;
            }

            j--;
            i++;
            while(i<m){
                if(!visited[i][j])
                    result.add(matrix[i][j]);
                visited[i][j] = true;
                i++;
            }
            j--;
            i--;

            while (j>=k){
                if(!visited[i][j])
                    result.add(matrix[i][j]);
                visited[i][j] = true;
                j--;
            }
            i--;
            j++;

            while(i>k){
                if(!visited[i][j])
                    result.add(matrix[i][j]);
                visited[i][j] = true;
                i--;
            }
            j++;
            i++;
            k++;
            n--;
            m--;
        }

        return result;
    }

    public static void main(String[] args) {
        _46_SpiralMatrix ob = new _46_SpiralMatrix();
        int [][] board = new int[6][4];
        board[0] = new int[]{1,2,3,4};
        board[1] = new int[]{5,6,7,8};
        board[2] = new int[]{9,10,11,12};
        board[3] = new int[]{13,14,15,16};
        board[4] = new int[]{17,18,19,20};
        board[5] = new int[]{21,22,23,24};
        System.out.println(ob.spiralOrder(board));

    }
}
