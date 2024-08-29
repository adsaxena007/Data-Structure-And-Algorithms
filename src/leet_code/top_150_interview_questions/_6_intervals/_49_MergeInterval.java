package leet_code.top_150_interview_questions._6_intervals;

import leet_code.top_150_interview_questions._4_Matrix._38_GameOfLife;

import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _49_MergeInterval {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0],b[0]));

        for (int[] interval : intervals) {
            if (list.isEmpty()) {
                list.add(interval);
                continue;
            }
            int[] temp = list.getLast();
            if (temp[1] >= interval[0]) {
                temp[1] = Math.max(temp[1], interval[1]);
                continue;
            }
            list.add(interval);
        }
        int [][] result = new int [list.size()][2];
        int i=0;
        for(int [] arr : list){
            result[i] = arr;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        _49_MergeInterval ob = new _49_MergeInterval();
        int [][] board = new int[4][2];
        board[0] = new int[]{1,3};
        board[1] = new int[]{2,6};
        board[2] = new int[]{8,10};
        board[3] = new int[]{15,18};

        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("======================");
        board = ob.merge(board);
        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }

    }

}
