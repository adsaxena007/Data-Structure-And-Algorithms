package leet_code.top_150_interview_questions._4_Matrix;

import java.util.HashSet;
import java.util.Set;

//
public class _34_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            Set<Character> s = new HashSet<>();
            for(int j=0;j<m;j++){
                if(board[i][j]!='.'){
                    if(s.contains(board[i][j])){
                        return false;
                    }
                    if(Integer.parseInt(board[i][j] + "")>9 || Integer.parseInt(board[i][j] + "")<1 )
                        return false;

                    s.add(board[i][j]);
                }
            }
        }

        for(int i=0;i<m;i++){
            Set<Character> s = new HashSet<>();
            for(int j=0;j<n;j++){
                if(board[j][i]!='.') {
                    if (s.contains(board[j][i])) {
                        return false;
                    }
                    s.add(board[j][i]);

                    if (Integer.parseInt(board[j][i] + "") > 9 || Integer.parseInt(board[j][i] + "") < 1)
                        return false;
                }
            }
        }

        int k=0, l=0;
        while (k<n){
            while(l<m){
                Set<Character> s = new HashSet<>();
                for(int i=k;i< k+3;i++){
                    for(int j=l;j<l+3;j++){
                        if(board[i][j]!='.'){
                            if(s.contains(board[i][j])){
                                return false;
                            }
                            if(Integer.parseInt(board[i][j] + "")>9 || Integer.parseInt(board[i][j] + "")<1 )
                                return false;

                            s.add(board[i][j]);
                        }
                    }
                }
                l = l+3;
            }
            l=0;
            k=k+3;
        }



        return true;
    }

    public static void main(String[] args) {
        _34_ValidSudoku ob = new _34_ValidSudoku();
        char [][] board = new char[9][9];
        board[0] = new char[]{'.','4','.','.','.','.','.','.','.'};
        board[1] = new char[]{'.','.','4','.','.','.','.','.','.'};
        board[2] = new char[]{'.','.','.','1','.','.','7','.','.'};
        board[3] = new char[]{'.','.','.','.','.','.','.','.','.'};
        board[4] = new char[]{'.','.','.','3','.','.','.','6','.'};
        board[5] = new char[]{'.','.','.','.','.','6','.','9','.'};
        board[6] = new char[]{'.','.','.','.','1','.','.','.','.'};
        board[7] = new char[]{'.','.','.','.','.','.','2','.','.'};
        board[8] = new char[]{'.','.','.','8','.','.','.','.','.'};

        System.out.println(ob.isValidSudoku(board));
    }
}