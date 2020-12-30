package SixFour;

class Solution {
    public int minPathSum(int[][] grid) {

        if(grid.length==1 && grid[0].length==1){
            return grid[0][0];
        }
        int m = grid.length;
        int n = grid[0].length;
        //int[][] ints = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 && j==0){
                }else if(i==0){
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                } else if ((j == 0)) {
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                }else {
                    if(grid[i-1][j]>grid[i][j-1]){
                        grid[i][j] = grid[i][j]+grid[i][j-1];
                    }else {
                        grid[i][j] = grid[i][j] + grid[i-1][j];
                    }
                }
            }
        }
        return grid[m-1][n-1];
    }
}
