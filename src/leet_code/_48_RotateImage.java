package leet_code;

public class _48_RotateImage {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int initial = 0;
        int i=initial,j=initial, rotations = n-1;
        while (rotations>=0){
            for(int k=0; k<rotations;k++){
                int temp = matrix[i][j];
                j++;
                while(j<n){
                    int temp2 = matrix[i][j];
                    matrix[i][j] = temp;
                    temp = temp2;
                    j++;
                }
                j--;
                i++;
                while(i<n){
                    int temp2 = matrix[i][j];
                    matrix[i][j] = temp;
                    temp = temp2;
                    i++;
                }
                i--;
                j--;
                while(j>=initial){
                    int temp2 = matrix[i][j];
                    matrix[i][j] = temp;
                    temp = temp2;
                    j--;
                }
                j++;
                i--;
                while(i>=initial){
                    int temp2 = matrix[i][j];
                    matrix[i][j] = temp;
                    temp = temp2;
                    i--;
                }
                i=initial;j=initial;
            }
            n--;
            initial++;
            i=initial;j=initial;
            rotations=rotations-2;
        }

    }

    public static void main(String[] args) {
        int [][] board = new int[4][4];
        board[0] = new int[]{1,2,3,4};
        board[1] = new int[]{5,6,7,8};
        board[2] = new int[]{9,10,11,12};
        board[3] = new int[]{13,14,15,16};

        _48_RotateImage ob = new _48_RotateImage();
        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("======================");
        ob.rotate(board);
        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
