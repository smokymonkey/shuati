package LeetCode;

/**
 * Created by jo0235 on 7/14/17.
 */
public class LC304 {
    static int[][] sum =null;
    public static void numMatrix(int[][] matrix) {
        int row =matrix.length;
        int col =matrix[0].length;
        sum=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int s1=(i-1)<0?0:sum[i-1][j];
                int s2=(j-1)<0?0:sum[i][j-1];
                int s3=((i-1)<0 || (j-1)<0)?0:sum[i-1][j-1];
                sum[i][j]=s1+s2-s3+matrix[i][j];
            }
        }
    }

    public static int sumRegion(int row1, int col1, int row2, int col2) {
        
        return sum[row2][col2]-sum[row1][col2]-sum[row2][col1]+sum[row1][col1];
    }

    public static void main(String[] args){
        int[][] NumMatrix=new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        numMatrix(NumMatrix);
        sumRegion(2,1,4,3);
        sumRegion(1,1,2,2);
        sumRegion(1,2,2,4);
    }
}
