public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return rst;
        }
        Arrays.sort(num);
        helper(num, 0, new ArrayList<Integer>(), rst);
        return rst;
    }
    void helper(int[] num, int start, List<Integer> cur, List<List<Integer>> rst) {
        rst.add(new ArrayList(cur));
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[i - 1]) {
                continue;
            }
            cur.add(num[i]);
            helper(num, i + 1, cur, rst);
            cur.remove(cur.size() - 1);
        }
    }
}