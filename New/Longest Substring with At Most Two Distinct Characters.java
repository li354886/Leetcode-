public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        int start = 0, last = -1, max = 0;
        for (int curr = 1; curr < n; curr++) {
            if (s.charAt(curr) != s.charAt(curr - 1)) {
                if (last >= 0 && s.charAt(curr) != s.charAt(last)) {
                    max = Math.max(max, curr - start);
                    start = last + 1;
                }
                last = curr - 1;
            }
        }
        return Math.max(n - start, max);
    }
}