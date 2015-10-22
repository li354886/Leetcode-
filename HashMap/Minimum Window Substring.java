public class Solution {
    public String minWindow(String S, String T) {
        if (S.length() == 0 || T.length() == 0 || S.length() < T.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        int count = 0; 
        int prev = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < S.length(); i++) {
            char currChar = S.charAt(i);
            if (map.containsKey(currChar)) {
                map.put(currChar, map.get(currChar) - 1);
                if (map.get(currChar) >= 0) {
                    count++;
                }
                while (count == T.length()) {
                    char prevChar = S.charAt(prev);
                    if (map.containsKey(prevChar)) {
                        map.put(prevChar, map.get(prevChar) + 1);
                        if (map.get(prevChar) > 0) {
                            if (minLen > i - prev + 1) {
                                minLen = i - prev + 1;
                                minStart = prev;
                            }
                            count--;
                        }
                    }
                    prev++;
                }
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        } else {
            return S.substring(minStart, minStart + minLen);
        }
    }
}