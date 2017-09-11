package LeetCode;

/**
 * Created by jie on 4/16/17.
 */
public class MaximalRectangle {
    public static void main(String[] args) {

    }
}
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int nrow=matrix.length;
        int ncol=matrix[0].length;
        int rt =0;
        int[] count=new int[ncol];
        for(int row=0;row<nrow;row++){
            for(int col=0;col<ncol;col++){
                count[col]=count[col]*matrix[row][col]+matrix[row][col];
            }
            int x=0;
            int minY=0;
            for (int col=0;col<ncol;col++){
                if(count[col]!=0){
                    x++;
                    if(minY==0)
                        minY=count[col];
                    else if(minY>count[col])
                        minY=count[col];
                }
                else{
                    x=0;
                    minY=0;
                }
                int area=minY*x;
                if(rt<area)
                    rt = area;

            }
        }
        return rt;

    }
}