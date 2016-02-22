public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int[] pos = new int[nums.length + 1];
        int[] neg = new int[nums.length + 1];
        pos[0] = nums[0];
        neg[0] = nums[0];
        int product = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pos[i] = neg[i] = nums[i];
            if (nums[i] > 0) {
                pos[i] = Math.max(pos[i - 1] * nums[i], pos[i]);
                neg[i] = Math.min(neg[i - 1] * nums[i], neg[i]);
            } else if (nums[i] < 0){
                pos[i] = Math.max(neg[i - 1] * nums[i], pos[i]);
                neg[i] = Math.min(pos[i - 1] * nums[i], neg[i]);
            }
            product = Math.max(product, pos[i]);
        }
        return product;
    }
}