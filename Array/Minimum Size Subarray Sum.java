public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = Integer.MAX_VALUE;
        int right = nums.length;
        int j = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (s == nums[i]) {
                return 1;
            }
            while (j < right && ans < s) {
                ans += nums[j];
                j++;
            }
            if (ans >= s) {
                len = Math.min(len, j - i);
            }
            ans -= nums[i];
        }
        if (len == Integer.MAX_VALUE) {
            return 0;
        } 
        return len;
    }
}