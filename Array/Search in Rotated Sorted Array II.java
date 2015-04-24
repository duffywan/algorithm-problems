public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return helper(nums, 0, nums.length - 1, target);
    }
    
    boolean helper(int[] nums, int i, int j, int target) {
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[i] == nums[mid] && nums[mid] == nums[j]) {
                return helper(nums, i, mid - 1, target) || helper(nums, mid + 1, j, target);
            } else if (nums[i] <= nums[mid]) {
                // left part is sorted
                if (nums[i] <= target && target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                // right part is sorted
                if (nums[mid] < target && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return false;
    }
}