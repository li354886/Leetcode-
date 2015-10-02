public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == 0) {
                    swap(nums, i, j);
                }
            }
        }
        return;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

