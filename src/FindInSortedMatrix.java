public class FindInSortedMatrix {
    public boolean solution(int target,int[][] matrix){
        int row = matrix.length;
        int column = matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=column-1;j>=0;j--){
                if(matrix[i][j]==target) {
                    System.out.println("true");
                    return true;
                }
                else if(matrix[i][j]>target){
                    column = column-1;
                }
                else{
                    break;
                }
            }
        }
        System.out.println("false");
        return false;
    }
}

class M4{
    public static void main(String[] args){
        FindInSortedMatrix f = new FindInSortedMatrix();
        int target = 7;
        int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        f.solution(target,matrix);
    }
}
