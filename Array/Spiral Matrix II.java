public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] rst = new int[n][n];
        int level = n / 2;
        int num = 1;
        for (int k = 0; k < level; k++) {
            for (int i = k; i < n - 1 - k; i++) {
                rst[k][i] = num++;
            }
            for (int i = k; i < n - 1 - k; i++) {
                rst[i][n - 1 - k] = num++;
            }
            for (int i = n - 1 - k; i > k; i--) {
                rst[n - 1 - k][i] = num++;
            }
            for (int i = n - 1 - k; i > k; i--) {
                rst[i][k] = num++;
            } 
        }
        if (n % 2 == 1) {
            rst[level][level] = num;
        }
        return rst;
    }
}