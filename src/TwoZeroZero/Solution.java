package TwoZeroZero;

/**
 * @author CoderiGenius
 * @version 2021/3/31 1:41 上午
 */
public class Solution {
    public int numIslands(char[][] grid) {

        if(grid.length==0)return 0;
        if(grid[0].length==0)return 0;
        int current = 1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    current++;
                    char i2 = (char)(current);
                    grid[i][j] = i2;
                    helper(i,j,grid);
                }
            }
        }
        return current-1;
    }
    private void helper(int i,int j,char[][] grid){

        if(i<grid.length-1){
            if(grid[i+1][j]!='0'){
                grid[i+1][j] = grid[i][j];
                helper(i+1,j,grid);
            }

        }

        if(i>0){
            if( grid[i-1][j]=='1'){
                grid[i-1][j] = grid[i][j];
                helper(i-1,j,grid);
            }

        }

        if(j<grid[0].length-1){
            if(grid[i][j+1]!='0'){
                grid[i][j+1] = grid[i][j];
                helper(i,j+1,grid);
            }
        }

        if(j>0){
            if(grid[i][j-1]=='1'){
                grid[i][j-1] = grid[i][j];
                helper(i,j-1,grid);
            }
        }

    }
//[["1","1","1"],["0","1","0"],["1","1","1"]]
    public static void main(String[] args) {
        System.out.println((int)'a');
        char[][] c = new char[3][3];
        c[0] = new char[]{'1','1','1'};
        c[1] = new char[]{'0','1','0'};
        c[2] = new char[]{'1','1','1'};
        System.out.println(new Solution().numIslands(c));
    }

}
