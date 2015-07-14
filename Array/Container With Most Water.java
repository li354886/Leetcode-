//If the right is higher, then we move the left

public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = 0;
        int r = height.length - 1;
        int l = 0;
        while (l < r) {
            result = Math.max(result, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++; 
            } else {
                r--;
            }
        }
        return result;
    }
}