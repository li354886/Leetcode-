public class Solution {
    public int titleToNumber(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - 'A' + 1;
            result = result*26 + num;
        }
        
        return result;
    }
}