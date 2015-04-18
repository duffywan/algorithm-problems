BETTER SOLUTIONS
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int j = s.length();
        for (int i = s.length() - 1; i >=0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            }else if (i == 0 || s.charAt(i - 1) == ' ') {
                return j - i;
            }
        }
        return 0;
    }
}

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = s.length() -1;
        int end = -1;
        int start = -1;
        while (i >= 0 && start == -1) {
            if (s.charAt(i) != ' ' && end == -1) {
                end = i;
            }
            // bug2: for index i, when if assigned end = i, should also check 
            // whether start = i, i can be both end and start. 
            // case "a"
            // if don't check, then will not find the start, return will 0, which is wrong
            if (end != -1 && s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                start = i;
            }
            i--;
        }
        // bug1: edgeCase like "    ". then start will be -1. 
        // if don't check when start == -1, then return value end - start + 1 will
        // produce wrong answer
        return start == -1 ? 0 : end - start + 1;
    }
}
