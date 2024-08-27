package leet_code;

public class _47_SetMatrixZero {
    public void setZerosApproach2ChatGPT(int [][]matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isFirstRowZero = false;
        boolean isColumnRowZero = false;
        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0){
                isColumnRowZero = true;
                break;
            }
        }

        for(int i=0;i<n;i++){
            if(matrix[0][i] == 0){
                isFirstRowZero = true;
                break;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0){
                int j=0;
                while (j<n){
                    matrix[i][j] = 0;
                    j++;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(matrix[0][i] == 0){
                int j=0;
                while (j<m){
                    matrix[j][i] = 0;
                    j++;
                }
            }
        }

        if(isColumnRowZero){
            for(int i=0; i<m; i++){
                matrix[i][0] = 0;
            }
        }

        if(isFirstRowZero){
            for(int i=0; i<n; i++){
                matrix[0][i] = 0;
            }
        }

    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        StringBuilder str = new StringBuilder();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] != 0 || str.toString().contains("'" + i + "-" + j+"';"))
                    continue;

                int temp1 = i;
                int temp2 = j;
                while(temp2>=0){
                    matrix[i][temp2] =0;
                    temp2--;
                }
                temp2 = j+1;
                while(temp2<n){
                    if(matrix[i][temp2] !=0){
                        str.append("'").append(i).append("-").append(temp2).append("';");
                    }
                    matrix[i][temp2] = 0;
                    temp2++;
                }

                while(temp1>=0){
                    matrix[temp1][j] =0;
                    temp1--;
                }
                temp1 = i+1;
                while(temp1<m){
                    if(matrix[temp1][j] !=0){
                        str.append("'").append(temp1).append("-").append(j).append("';");
                    }
                    matrix[temp1][j] =0;
                    temp1++;
                }
            }
        }
    }

    public static void main(String[] args) {
        _47_SetMatrixZero ob = new _47_SetMatrixZero();
        int [][] board = new int[14][6];
        board[0]  = new int[]{2,9,3,9,8,9};
        board[1]  = new int[]{6,0,0,4,2,3};
        board[2]  = new int[]{5,0,3,7,5,8};
        board[3]  = new int[]{4,7,2,1,1,4};
        board[4]  = new int[]{0,4,4,1,5,5};
        board[5]  = new int[]{2,7,6,5,9,4};
        board[6]  = new int[]{6,7,7,8,3,1};
        board[7]  = new int[]{2,9,1,5,8,8};
        board[8]  = new int[]{5,2,5,9,6,9};
        board[9]  = new int[]{3,8,5,9,9,0};
        board[10] = new int[]{4,2,8,2,9,9};
        board[11] = new int[]{9,6,8,6,6,1};
        board[12] = new int[]{7,8,2,0,5,3};
        board[13] = new int[]{8,3,5,5,2,3};


        ob.setZerosApproach2ChatGPT(board);
        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
