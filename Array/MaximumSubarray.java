public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int prevSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prevSum = nums[i] + (prevSum > 0 ? prevSum : 0);
            maxSum = Math.max(maxSum, prevSum);
        }
        return maxSum;
    }
}
