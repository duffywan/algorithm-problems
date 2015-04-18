public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder[] list = new StringBuilder[nRows];
        for (int j = 0; j < nRows; j++) {
            list[j] = new StringBuilder();
        }
        StringBuilder rst = new StringBuilder();
        int c = 0;
        while (c < s.length()) {
            // traversing down
            for (int j = 0; j < nRows && c < s.length(); j++) {
                list[j].append(s.charAt(c++));
            }
            // traversing up
            for (int j = nRows - 2; j > 0 && c < s.length(); j--) {
                list[j].append(s.charAt(c++));
            }
        }
        for (int i = 0; i < nRows; i++) {
            rst.append(list[i]);
        }
        return rst.toString();
    }
}