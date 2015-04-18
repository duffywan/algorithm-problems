public class Solution {
    // Time O(n)
    // space O(n)
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int start = 0;
        for (int end = 0; end <= s.length(); end++) {
            if (end < s.length() && !set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
            } else {
                max = Math.max(max, end - start);
                if (end < s.length()) {
                    while (set.contains(s.charAt(end))) {
                        set.remove(s.charAt(start));
                        start++;
                    }
                    set.add(s.charAt(end));
                }
            }
        }
        return max;
    }
}

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        int[] dp = new int[s.length()]; // start index of string ending at position i;
        for(int i = 1; i < dp.length; i++) {
            String last = s.substring(dp[i - 1], i);
            dp[i] = last.lastIndexOf(s.charAt(i)) + dp[i - 1] + 1;
            maxLength = Math.max(maxLength, i - dp[i] + 1);
        }
        return maxLength;
    }
}