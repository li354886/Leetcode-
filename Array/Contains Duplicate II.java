public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                int pre = map.get(nums[i]);
                min = Math.min(i - pre, min);
            }
            map.put(nums[i], i);
        }
        
        if (min <= k) {
            return true;
        } else {
            return false;
        }
    }
}