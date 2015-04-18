public class Solution {
    // space: except the returned value, O(length of the longest ip address xxx.xxx.xxx.xx)
    // time: ???
    public List<String> restoreIpAddresses(String s) {
        List<String> rst = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return rst;
        }
        helper(s, 0, 0, new StringBuilder(), rst);
        return rst;
    }
    void helper(String s, int sIndex, int seg, StringBuilder cur, List<String> rst) {
        if (sIndex >= s.length() || seg >= 4) {
            if (sIndex == s.length() && seg == 4) {
                rst.add(cur.toString());
            }
            return;
        }
        for (int i = 0; i < 3 && sIndex + i < s.length(); i++) {
            String sub = s.substring(sIndex, sIndex + i + 1);
            if (s.charAt(sIndex) == '0' && i > 0 || i == 2 && Integer.parseInt(sub) > 255) {
                continue;    
            }
            if (seg > 0) {
                cur.append('.');
            }
            cur.append(sub);
            helper(s, sIndex + i + 1, seg + 1, cur, rst);
            cur.delete(cur.length() - sub.length(), cur.length());
            if (seg > 0) {
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}