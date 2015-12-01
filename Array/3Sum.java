public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < 0) {
                    left++;
                }else if (sum > 0) {
                    right--;
                }else {
                    // List<Integer> tmp = new ArrayList<>();
                    // tmp.add(nums[i]);
                    // tmp.add(nums[left]);
                    // tmp.add(nums[right]);
                    // result.add(tmp);
                    // left++;
                    // right--;
                    // if (left < right && nums[left] == nums[left - 1]) {
                    //     left++;
                    // } 
                    // if (left < right && nums[right] == nums[right + 1]) {
                    //     right--;
                    // }
                    
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    result.add(tmp);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}