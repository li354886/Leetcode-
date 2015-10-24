public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            int len = 1;
            for (int j = i + 1; set.contains(j); j++) {
                len++;
                set.remove(j);
            }
            for (int j = i - 1; set.contains(j); j--) {
                len++;
                set.remove(j);
            }
            // set.remove(i);
            max = Math.max(max, len);
        }
        return max;
    }
}