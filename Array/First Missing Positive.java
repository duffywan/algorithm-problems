public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        // in-place bucket sort, put nums[i] stores i + 1
        int i = 0;
        while (i < nums.length) {
            // cases: nums[nums[i] - 1] == (nums[i] - 1) + 1)
            // this is the case when the correct position already put the correct value
            // otherwise the loop won't ends
            // because i won't increment
            if (nums[i] <= 0 || nums[i] > nums.length || nums[nums[i] - 1] == (nums[i] - 1) + 1) {
                i++;
                continue;
            }
            swap(nums, i, nums[i] - 1);
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}