public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < A.length; j++) {
            if (A[j] != A[i] || A[j] == A[i] && (i - 1 < 0 || A[j] != A[i - 1])) {
                A[++i] = A[j];
            }
        }
        return i + 1;
    }
}