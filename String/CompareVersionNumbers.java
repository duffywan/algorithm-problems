public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        /*Q1: all version numbers must contain '.'? no*/
        /*Q2: 1.0 and 1? return 0*/
        int s1 = 0;
        int s2 = 0;
        int e1 = 1;
        int e2 = 1;
        while (e1 <= version1.length() || e2 <= version2.length()) {
            if (e1 < version1.length() && version1.charAt(e1) != '.') {
                e1++;
                continue;
            }
            if (e2 < version2.length() && version2.charAt(e2) != '.') {
                e2++;
                continue;
            }
            /*bugs: fail to check s1 and s2 exceed bonds*/
            int num1 = s1 < version1.length() ? Integer.parseInt(version1.substring(s1, e1)) : 0;
            int num2 = s2 < version2.length() ? Integer.parseInt(version2.substring(s2, e2)) : 0;
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            } else {
                e1++;
                e2++;
                s1 = e1;
                s2 = e2;
            }
        }
        return 0;
    }
}