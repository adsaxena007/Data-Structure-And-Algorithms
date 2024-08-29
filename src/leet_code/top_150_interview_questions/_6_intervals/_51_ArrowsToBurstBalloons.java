package leet_code.top_150_interview_questions._6_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class _51_ArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if(points.length == 1)
            return 1;
        boolean[] didBurst = new boolean[points.length];
        Arrays.sort(points, (a,b)-> Integer.compare(a[1],b[1]));
        for(int i=0;i<points.length;i++){
            if(!didBurst[i]){
                for(int j=i+1;j<points.length;j++){
                    if(points[i][1] >= points[j][0] && points[i][1] <= points[j][1]){
                        didBurst[j] = true;
                    }
                }
            }
        }
        int arrowCount = 0;
        for(boolean el : didBurst){
            if(el)
                continue;

            arrowCount++;
        }
        return arrowCount;
    }
    public int findMinArrowShotsApproach2(int[][] points) {
        if(points.length == 1)
            return 1;

        Arrays.sort(points, (a,b)-> Integer.compare(a[1],b[1]));
        int arrowCount = 1;
        int currentEnd = points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0] > currentEnd){
                arrowCount++;
                currentEnd = points[i][1];
            }
            i++;
        }
        return arrowCount;
    }

    public static void main(String[] args) {
        _51_ArrowsToBurstBalloons ob = new _51_ArrowsToBurstBalloons();
        int [][] board = {
                {7, 15},
                {6, 14},
                {8, 12},
                {3, 4},
                {4, 13},
                {6, 14},
                {9, 11},
                {6, 12},
                {4, 13}
        };






        System.out.println(ob.findMinArrowShotsApproach2(board));
    }
}
