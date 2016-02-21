public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int tmpmax = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmpmax = Math.max(nums[i] + tmpmax, nums[i]);
            dp[i] = tmpmax;
        }
        int max = Integer.MIN_VALUE;
        for (int a : dp) {
            max = Math.max(a, max);
        }
        return max;
        // if(nums==null || nums.length==0) return 0;
        // if(nums.length==1) return nums[0];

        // int len = nums.length;
        // int[] dp = new int[len];
        // int max = nums[0];
        // dp[0] = nums[0];
        // for(int i=1; i<len; i++){
        //     max = Math.max(nums[i]+max, nums[i]);
        //     dp[i] = max;
        // }
        // for(int a: dp){
        //     if(a>max) max = a;
        // }
        // return max;
    }
}