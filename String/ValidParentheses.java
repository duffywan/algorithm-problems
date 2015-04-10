public class Solution {
	// space: O(n), n is the length of string s
	// time: O(n)
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if (s.charAt(i) == ']' && last != '[' ||
                    s.charAt(i) == '}' && last != '{' ||
                    s.charAt(i) == ')' && last != '(') {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}