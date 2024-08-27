package leet_code.top_150_interview_questions._4_Matrix;

public class _38_GameOfLife {
    public void gameOfLife(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 1 -> 5, 0 -> 10

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int sum = 0;
                if(j-1 >=0 && i-1 >=0){
                    sum = sum
                            + (matrix[i][j-1] == 10 ? 0 : (matrix[i][j-1] == 5 ? 1 : matrix[i][j-1]))
                            + (matrix[i-1][j] == 10 ? 0 : (matrix[i-1][j] == 5 ? 1 : matrix[i-1][j]))
                            + (matrix[i-1][j-1] == 10 ? 0 : (matrix[i-1][j-1] == 5 ? 1 : matrix[i-1][j-1]));

                }else if(j-1 >=0){
                    sum = sum
                            + (matrix[i][j-1] == 10 ? 0 : (matrix[i][j-1] == 5 ? 1 : matrix[i][j-1]));
                }else if(i-1 >=0){
                    sum = sum
                            + (matrix[i-1][j] == 10 ? 0 : (matrix[i-1][j] == 5 ? 1 : matrix[i-1][j]));
                }

                if(i+1<m && j+1<n){
                    sum = sum
                            + (matrix[i][j+1] == 10 ? 0 : (matrix[i][j+1] == 5 ? 1 : matrix[i][j+1]))
                            + (matrix[i+1][j] == 10 ? 0 : (matrix[i+1][j] == 5 ? 1 : matrix[i+1][j]))
                            + (matrix[i+1][j+1] == 10 ? 0 : (matrix[i+1][j+1] == 5 ? 1 : matrix[i+1][j+1]));

                }else if(j+1 < n){
                    sum = sum
                            + (matrix[i][j+1] == 10 ? 0 : (matrix[i][j+1] == 5 ? 1 : matrix[i][j+1]));

                }else if(i+1 < m){
                    sum = sum
                            + (matrix[i+1][j] == 10 ? 0 : (matrix[i+1][j] == 5 ? 1 : matrix[i+1][j]));
                }

                if(i-1>=0 && j+1<n){
                    sum = sum
                            + (matrix[i-1][j+1] == 10 ? 0 : (matrix[i-1][j+1] == 5 ? 1 : matrix[i-1][j+1]));
                }

                if(i+1<m && j-1>=0){
                    sum = sum
                            + (matrix[i+1][j-1] == 10 ? 0 : (matrix[i+1][j-1] == 5 ? 1 : matrix[i+1][j-1]));
                }

                if(sum == 3 && matrix[i][j] == 0){
                    matrix[i][j] = 10;
                }

                if((sum < 2 || sum > 3 ) && matrix[i][j] == 1){
                    matrix[i][j] = 5;
                }
            }
        }

        for (int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
             if(matrix[i][j] == 10){
                 matrix[i][j] = 1;
             }

                if(matrix[i][j] == 5){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        int [][] board = new int[4][3];
        board[0] = new int[]{0,1,0};
        board[1] = new int[]{0,0,1};
        board[2] = new int[]{1,1,1};
        board[3] = new int[]{0,0,0};

        _38_GameOfLife ob = new _38_GameOfLife();
        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("======================");
        ob.gameOfLife(board);
        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
