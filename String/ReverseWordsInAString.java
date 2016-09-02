public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        
        int start = 0;
        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
    }
    private void reverse(char[] c, int start, int end) {
        while (start < end) {
            char tmp = c[start];
            c[start++] = c[end];
            c[end--] = tmp;
        }
    }
}