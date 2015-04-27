public class Solution {
    // time O(n)
    // space O(n)
    
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i + 1};
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i + 1);
            }
        }
        return new int[]{-1, -1};
    }
}