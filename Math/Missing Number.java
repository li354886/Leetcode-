public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        if(nums.length == 0 || nums[0] != 0) return res;

        for(int i = 1; i < nums.length; i ++) {
            if((nums[i] - 1) != nums[i - 1]) {
                res = i;
                return res;
            }
            res++;
        }
        return res + 1;
    }
} */