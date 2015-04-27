public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (S == null || S.length == 0) {
            return rst;
        }
        // sort input array for checking duplicates and put elements of subsets in increasing order
        Arrays.sort(S);
        helper(S, 0, new ArrayList<Integer>(), rst);
        return rst;
    }
    void helper(int[] S, int start, List<Integer> cur, List<List<Integer>> rst) {
        rst.add(new ArrayList(cur));
        for (int i = start; i < S.length; i++) {
            // no duplicates in one level
            if (i > start && S[i] == S[i - 1]) {
                continue;
            }
            cur.add(S[i]);
            helper(S, i + 1, cur, rst);
            cur.remove(cur.size() - 1);
        }
    }
}