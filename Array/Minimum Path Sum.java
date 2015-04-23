public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] cost = new int[grid.length][grid[0].length];
        cost[0][0] = grid[0][0];
        for (int i = 1; i < cost.length; i++) {
            cost[i][0] = grid[i][0] + cost[i - 1][0];
        }
        for (int i = 1; i < cost[0].length; i++) {
            cost[0][i] = grid[0][i] + cost[0][i - 1];
        }
        for (int i = 1; i < cost.length; i++) {
            for (int j = 1; j < cost[0].length; j++) {
                cost[i][j] = grid[i][j] + Math.min(cost[i - 1][j], cost[i][j - 1]); 
            }
        }
        return cost[cost.length - 1][cost[0].length - 1];
    }
}