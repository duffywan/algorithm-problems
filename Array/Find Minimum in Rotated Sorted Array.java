public class Solution {
    public int findMin(int[] nums) {
        // binary search
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;
        while (i < j) {
            if (i + 1 == j) {
                return Math.min(nums[i], nums[j]);
            }
            mid = i + (j - i) / 2;
            // if the array is sorted
            if (nums[i] <= nums[mid] && nums[mid] <= nums[j]) {
                return nums[i];
            } else if (nums[i] > nums[mid]) {
                j = mid;
            } else {
                i = mid;
            }
        }
        // handle when nums has only 1 element. because binary search loop condition is i < j
        // if nums === [1] then we will not go into the loop.
        // in this case should return the first as well as the only element in nums
        return nums[mid];
    }
}