public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currentsum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentsum = currentsum + nums[i];
            if (currentsum > max) {
                max = currentsum;
            }
            if (currentsum < 0) {
                currentsum = 0;
            }
        }
        return max;
    }
}