package LeetCode;

/**
 * Created by allen on 6/12/15.
 */

/**
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // initialize top row
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i - 1][0];
        }
        // initialize top column
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j -1] + grid[0][j -1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j -1]) + grid[i][j];
            }
        }
        return dp[m -1][n -1];
    }


    public int minPathSum2(int[][] grid) {
        return dfs(0,0,grid);
    }

    public int dfs(int i, int j, int[][] grid){
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }

        if(i<grid.length-1 && j<grid[0].length-1){
            int r1 = grid[i][j] + dfs(i+1, j, grid);
            int r2 = grid[i][j] + dfs(i, j+1, grid);
            return Math.min(r1,r2);
        }

        if(i<grid.length-1){
            return grid[i][j] + dfs(i+1, j, grid);
        }

        if(j<grid[0].length-1){
            return grid[i][j] + dfs(i, j+1, grid);
        }

        return 0;
    }
}
