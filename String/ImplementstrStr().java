public class Solution {
	// space: O(1)
    // time: O(n^2)
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null  || needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.equals(haystack) || needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        int start = 0;
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                j = 0;
                i = ++start;
            } else {
                i++;
                j++;
            }
        }
        return j == needle.length() ? start : -1;
    }
}