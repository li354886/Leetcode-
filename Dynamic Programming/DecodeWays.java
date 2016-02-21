public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') d[i] += d[i - 1];
            if (i >= 2 && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                d[i] += d[i - 2];
            }
        }
        
        // for (int i = 1; i <= n; i++) {
        //     if (s.charAt(i - 1) != '0')  d[i] += d[i - 1];
        //     if (i >= 2 && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))
        //         d[i] += d[i - 2];
        // }
        return d[n];
    }
}