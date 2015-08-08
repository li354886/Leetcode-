public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carries = 0;
        String result = "";
        while (pb >= 0) {
            int sum = (int)(a.charAt(pa) - '0') + (int)(b.charAt(pb) - '0') + carries;
            result = String.valueOf(sum % 2) + result;
            carries = sum / 2;
            pb--;
            pa--;
        }
        while (pa >= 0) {
            int sum = (int)(a.charAt(pa) - '0') + carries;
            result = String.valueOf(sum % 2) + result;
            carries = sum / 2;
            pa--;
        }
        if (carries == 1) {
            result = "1" + result;
        }
        return result;
    }
}