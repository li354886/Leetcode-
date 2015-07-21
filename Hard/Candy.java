public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] num = new int[ratings.length];
        
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                num[i] = num[i - 1] + 1;
            } else {
                num[i] = 1;
            }
        }
        
        int sum = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                num[i] = Math.max(num[i], num[i + 1] + 1);
            }
            sum += num[i];
        }
        return sum;
    }
}