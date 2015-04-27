public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                if (Math.abs(nums[i] + nums[j] + nums[k] - target) < diff) {
                    diff = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    sum = nums[i] + nums[j] + nums[k];
                }
                if (nums[i] + nums[j] + nums[k] == target) {
                    return target;
                } else if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return sum;
    }
}