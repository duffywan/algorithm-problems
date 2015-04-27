public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return rst;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>(), rst);
        return rst;
    }
    void helper(int[] candidates, int start, int target, List<Integer> cur, List<List<Integer>> rst) {
        // wrong: forget to add when target < 0 to end the recursive call
        // otherwise for input[2], 1
        // the program will call helper endless times
        if (target < 0) {
            return;
        }
        if (target == 0) {
            rst.add(new ArrayList(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // because we set the recursive call start index to i
            // here we don't allow duplicates
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur.add(candidates[i]);
            helper(candidates, i, target - candidates[i], cur, rst);
            cur.remove(cur.size() - 1);
        }
    }
}