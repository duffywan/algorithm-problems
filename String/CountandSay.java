public class Solution {
    public String countAndSay(int n) {
        StringBuilder seq = new StringBuilder("1");
        for (int i = 0; i < n - 1; i++) {
            StringBuilder nextSeq = new StringBuilder();
            int count = 1;
            for (int j = 1; j <= seq.length(); j++) {
                if (j == seq.length() || seq.charAt(j) != seq.charAt(j - 1)) {
                    nextSeq.append(count);
                    nextSeq.append(seq.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }
            seq = nextSeq;
        }
        return seq.toString();
    }
}
