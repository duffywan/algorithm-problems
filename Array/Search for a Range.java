public class Solution {
    // time
    // space
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        int i = 0;
        int j = nums.length - 1;
        while(i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                // search end and start position for the target value
                int start = mid - 1;
                while (start >= 0 && nums[start] == target) {
                    start--;
                }
                int end = mid + 1;
                while (end < nums.length && nums[end] == target) {
                    end++;
                }
                return new int[]{start + 1, end - 1};
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}