public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return rst;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2 && num[i] <= 0; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    j++;
                    continue;
                }
                if (k < num.length - 1 && num[k] == num[k + 1]) {
                    k--;
                    continue;
                }
                int sum = num[i] + num[j] + num[k];
                if (sum == 0) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(num[i]);
                    cur.add(num[j]);
                    cur.add(num[k]);
                    rst.add(cur);
                    j++;
                    k--;
                } else if (sum < 0){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return rst;
    }
}