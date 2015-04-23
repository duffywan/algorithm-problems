public class Solution {
    public int[] plusOne(int[] digits) {
        // case to consider: overflow, carry
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry == 0) {
            int[] rst = Arrays.copyOf(digits, digits.length);
            return rst;
        }
        // if the most significate digit is more than 10.
        int[] rst = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            rst[i + 1] = digits[i];   
        }
        rst[0] = carry;
        return rst;
    }
}