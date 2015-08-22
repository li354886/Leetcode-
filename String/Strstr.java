public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null && needle == null) {
            return -1;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        
        for (int i = 0; i <= len1 - len2; i++) {
            int j = 0;
            for (j = 0; j < len2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == len2) {
                return i;
            }
        }
        return -1;
    }
}