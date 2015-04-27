public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int curRange = 0;
        int nextRange = 0;
        for (int i = 0; i < nums.length; i++) {
            nextRange = Math.max(nextRange, i + nums[i]);
            if (i == curRange) {
                if (nextRange >= nums.length - 1){
                    return true;
                }
                curRange = nextRange;
            }
        }
        return false;
    }
}