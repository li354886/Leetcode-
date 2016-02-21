public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int start = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(i) >= start) {
                    start = map.get(s.charAt(i)) + 1;
                }
            }
            map.put(s.charAt(i), i);
            int subLen = i - start + 1;
            max = Math.max(max, subLen);
        }
        return max;
        
        
        // // int len = s.length();
        // // HashMap<Character, Integer> map = new HashMap<>();
        // // int max = 0;
        // // int start = 0;
        
        // for (int end = 0; end < len; end++) {
        //     char c = s.charAt(end);
        //     if (map.containsKey(c)) {
        //         if (map.get(c) >= start) {
        //             start = map.get(c) + 1;
        //         }
        //     }
        //     map.put(c, end);
        //     int subLen = end - start + 1;
        //     max = Math.max(max, subLen);
        // }
        // return max;
    }
}