package LeetCode;

public class ReverseMatrix_867 {
    public int[][] transpose(int[][] A) {
        int rowCount = A.length;
        int columnCount = A[0].length;
        int[][] B = new int[columnCount][rowCount];
        for(int i=0; i<columnCount;i++){
            for(int j=0;j<rowCount;j++){
                int cell = A[j][i];
                B[i][j] = cell;
            }
        }
        return B;
    }
}

class Solution{
    public static void main(String[] args){
        ReverseMatrix_867 reverseMatrix = new ReverseMatrix_867();
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] B = reverseMatrix.transpose(A);
        for(int[] row:B){
            for(int cell:row){
                System.out.println(cell);
            }
        }
    }
}
