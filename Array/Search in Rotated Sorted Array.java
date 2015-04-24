public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[i] <= nums[mid]) { // if left part is sorted
                if (nums[i] <= target && target < nums[mid]) { // if target is in the sorted part
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else { // if nums[mid] <= nums[j], then right part is sorted
                if (nums[mid] < target && target <= nums[j]) { // if target is in the sorted part
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }
}