public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        int i = 0;
        for (i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                break;
            }
        }
        reverse(num, i + 1, num.length - 1);
        if (i == -1) {
            // if we rotated the whole array
            return;
        }
        int j = 0;
        for (j = i + 1; j < num.length; j++) {
            // find the smallest element in the reversed subarray that is larger than num[i]
            if (num[j] > num[i]) {
                break;
            }
        }
        swap(num, i, j);
    }
    void reverse(int[] num, int start, int end) {
        while (start < end) {
            swap(num, start++, end--);
        }
    }
    void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}