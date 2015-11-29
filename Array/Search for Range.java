public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int[] bound = new int[2];
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (nums[low] == target) {
            bound[0] = low;
        } else if (nums[high] == target) {
            bound[0] = high;
        }else {
            bound[0] = bound[1] = -1;
        }
        
        low = 0;
        high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                low = mid;
            }else if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (nums[high] == target) {
            bound[1] = high;
        } else if (nums[low] == target) {
            bound[1] = low;
        } else {
            bound[0] = bound[1] = -1;
        }
        return bound;
    }
}