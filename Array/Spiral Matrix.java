public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return rst;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int rows = m;
        int cols = n;
        int level = Math.min(rows, cols) / 2; // total number of complete sub matrixes
        for (int k = 0; k < level; k++) {
            for (int j = k; j < n - 1 - k; j++) {
                rst.add(matrix[k][j]); // left to right
            }
            for (int j = k; j < m - 1 - k; j++) {
                rst.add(matrix[j][n - 1 - k]); // top to bottom
            }
            for (int j = n - 1 - k; j > k; j--) { 
                rst.add(matrix[m - 1 - k][j]); // right ot left
            }
            for (int j = m - 1 - k; j > k; j--) {
                rst.add(matrix[j][k]); // bottom to top
            }
            rows -= 2;
            cols -= 2;
        }
        for (int i = level; i < level + rows; i++) {
            for (int j = level; j < level + cols; j++) {
                rst.add(matrix[i][j]);
            }
        }
        return rst;
    }
}