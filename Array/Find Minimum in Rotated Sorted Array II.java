public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1);
    }
    
    int helper(int[] nums, int i, int j) {
        while (i < j) {
            if (i + 1 == j) {
                return Math.min(nums[i], nums[j]);
            }
            int mid = i + (j - i) / 2;
            // case: if nums is sorted [1,3,3]
            // if the array must have been rotated
            // then the condition can be nums[i] == nums[mid] == nums[j]
            if (nums[i] <= nums[mid] && nums[mid] <= nums[j]) {
                return Math.min(helper(nums, i, mid), helper(nums, mid + 1, j));
            } else if (nums[i] <= nums[mid]) {
                // left part sorted
                i = mid;
            } else {
                // right part sorted
                j = mid;
            }
        }
        return nums[i];
    }
}