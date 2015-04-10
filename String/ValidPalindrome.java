public class Solution {
	space: O(n) because of toLowerCase method
	Time: O(n)
    public boolean isPalindrome(String s) {
        String lowers = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!isNumberOrLetter(i, lowers)) {
                i++;
                continue;
            }
            if (!isNumberOrLetter(j, lowers)) {
                j--;
                continue;
            }
            if (lowers.charAt(i) != lowers.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public boolean isNumberOrLetter(int i, String s) { 
        return s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) >= 'a' && s.charAt(i) <= 'z';
    }
}