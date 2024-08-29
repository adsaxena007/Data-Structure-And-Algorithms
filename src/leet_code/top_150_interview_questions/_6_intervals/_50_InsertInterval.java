package leet_code.top_150_interview_questions._6_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class _50_InsertInterval {
    public List<int[]> merge(List<int[]> intervals) {
        List<int[]> list = new ArrayList<>();
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
        return list;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            int[][] temp = new int[1][2];
            temp[0] = newInterval;
            return temp;
        }
        int i=0;
        List<int[]> intervalsList = new CopyOnWriteArrayList<>(List.of(intervals));
        for(int[] currentInterval : intervalsList){
            if(newInterval[0] < currentInterval[0]){
                intervalsList.add(i, newInterval);
                break;
            }
            if(i == intervals.length-1) {
                intervalsList.add(newInterval);
                break;
            }
            i++;
        }
        List<int[]> mergedIntervals = merge(intervalsList);

        int [][] result = new int [mergedIntervals.size()][2];
        int k=0;
        for(int [] arr : mergedIntervals){
            result[k] = arr;
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        _50_InsertInterval ob = new _50_InsertInterval();
        int [][] board = new int[1][2];
        board[0] = new int[]{1,5};


        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("======================");
        board = ob.insert(board, new int[]{2,7});
        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
