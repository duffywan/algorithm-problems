public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if ((mid - 1 == -1 || nums[mid - 1] < nums[mid]) && (mid + 1 == nums.length || nums[mid] > nums[mid + 1])) {
                return mid;     
            } else if (mid - 1 == -1 || nums[mid - 1] < nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
}