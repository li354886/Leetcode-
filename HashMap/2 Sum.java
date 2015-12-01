public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Arrays.sort(nums);
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int index1 = i + 1;
                int index2 = map.get(target - nums[i]);
                if (index1 == index2) {
                    continue;
                }
                a[0] = index1;
                a[1] = index2;
                return a;
            }
        }
        return a;
    }
}