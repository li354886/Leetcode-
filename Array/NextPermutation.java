public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        
        int len = num.length;
        
        int i = len - 2; //this to to avoid left = i + 1 error
        for (; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                break;
            }
        }
        
        if (i != -1) {
            for (int j = len - 1; j > i; j--) {
                if (num[j] > num[i]) {
                    swap(num, i, j);
                    break;
                }
            }
        }
        
        
        int left = i + 1;
        int right = len - 1;
        while (left < right) {
            swap(num, left, right);
            left++;
            right--;
        }
    }
    
    public void swap (int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}