public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int index0 = 0; // all elements before index0 is 0
        int index2 = A.length - 1; // all elements after index2 is 2
        int i = 0;
        // elements between [index0, index2] is to be processed.
        while (i <= index2) {
            if (A[i] == 0) {
                swap(A, index0++, i++);
            } else if (A[i] == 1) {
                i++;
            } else {
                swap(A, index2--, i);
            }
        }
    }
    void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}