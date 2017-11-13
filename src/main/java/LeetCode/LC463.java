package LeetCode;

/**
 * Created by jo0235 on 9/12/17.
 */
public class LC463 {
    public int islandPerimeter(int[][] grid) {
        int rt =0;
        int row=grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(grid[i][j]==1) {
                    rt += 4;
                    if ((i - 1) >= 0 && grid[i - 1][j] == 1)
                        rt -= 2;
                    if ((j - 1) >= 0 && grid[i][j - 1] == 1)
                        rt -= 2;
                }
            }
        return rt;

    }
    public static void main(String[] args){
        new LC463().islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}});
    }
}

