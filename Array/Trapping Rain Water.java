public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int sum = 0;
        int[] leftBar = new int[height.length];
        for (int i = 1; i < leftBar.length; i++) {
            leftBar[i] = Math.max(leftBar[i - 1], height[i - 1]);
        }
        int[] rightBar = new int[height.length];
        for (int i = rightBar.length - 2; i >= 0; i--) {
            rightBar[i] = Math.max(rightBar[i + 1], height[i + 1]);
        }
        // add up all the trapped water for each bar at index i
        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(rightBar[i], leftBar[i]);
            sum += minHeight > height[i] ? minHeight - height[i] : 0;
        }
        return sum;
    }
}