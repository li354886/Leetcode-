public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
               return;    
        }
        
        int len = A.length - 1;
        int left = 0;
        int right = len;
        
        int cur = 0;
        while (cur <= right) {
            if (A[cur] == 2) {
                swap(A, cur, right);
                right--;
            }else if(A[cur] == 0) {
                swap(A, cur, left);
                left++;
                cur++;
            }else{
                cur++;
            }
        }
    }
    
    public void swap(int[] A, int n1, int n2){
        int tmp = A[n1];
        A[n1] = A[n2];
        A[n2] = tmp;
    }
}