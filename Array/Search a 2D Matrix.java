public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = m * n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int mid_i = mid / n;
            int mid_j = mid % n;
            if (matrix[mid_i][mid_j] == target) {
                return true;
            } else if (matrix[mid_i][mid_j] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}