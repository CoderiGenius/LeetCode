package SixTwo;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {



        if(obstacleGrid.length==1 && obstacleGrid[0].length==1){
            if(obstacleGrid[0][0]!=1)
                return 1;
            else return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1]==1){
            return 0;
        }
        int[][] ints = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 && j==0){
                    ints[i][j] = 0;
                }else if(i==0){
                    if(obstacleGrid[i][j-1]!=1){
                        ints[i][j] = ints[i][j-1];
                    }else {
                        ints[i][j] = 0;
                    }
                }else if(j==0){
                    if(obstacleGrid[i-1][j]!=1){
                        ints[i][j] = ints[i-1][j];
                    }else {
                        ints[i][j] = 0;
                    }
                }else {
                    int up = 0;
                    int left = 0;
                    if(obstacleGrid[i-1][j]!=1){
                        left = ints[i-1][j];
                    }
                    if(obstacleGrid[i][j-1]!=1){
                        up = ints[i][j-1];
                    }
                    ints[i][j] = up+left;
                }
            }
        }
        return ints[m-1][n-1];
    }
}