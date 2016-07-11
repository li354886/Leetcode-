public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int secondmin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num < secondmin) {
                secondmin = num;
            } else if (num > secondmin){
                return true;
            }
        }
        return false;
    }
}