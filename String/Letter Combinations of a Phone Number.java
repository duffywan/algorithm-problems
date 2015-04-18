public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        String[] dict = new String[10];
        dict[2] = "abc";
        dict[3] = "def";
        dict[4] = "ghi";
        dict[5] = "jkl";
        dict[6] = "mno";
        dict[7] = "pqrs";
        dict[8] = "tuv";
        dict[9] = "wxyz";
        helper(dict, new StringBuilder(), list, digits);
        return list;
    }
    
    void helper(String[] dict, StringBuilder cur, List<String> list, String digits) {
        if (cur.length() == digits.length()) {
            list.add(cur.toString());
            return;
        }
        int index = digits.charAt(cur.length()) - '0';
        for (int i = 0; i < dict[index].length(); i++) {
            cur.append(dict[index].charAt(i));
            helper(dict, cur, list, digits);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> rst = new ArrayList<String>();
        if (digits == null) {
            return rst;
        }
        String[] dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, dict, 0, new StringBuilder(), rst);
        return rst;
    }
    void helper(String digits, String[] dict, int pos, StringBuilder sb, List<String> rst) {
        if (pos == digits.length()) {
            rst.add(new String(sb));
            return;
        }
        String map = dict[digits.charAt(pos) - '2'];
        for (int i = 0; i < map.length(); i++) {
            sb.append(map.charAt(i));
            helper(digits, dict, pos + 1, sb, rst);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
}