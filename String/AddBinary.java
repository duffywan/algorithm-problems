public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >=0 || j >=0) {
            int a_num = i >= 0 ? a.charAt(i) - '0' : 0;
            int b_num = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = a_num + b_num + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}