public class Solution {
    public int findMin(int[] num) {
        if(num == null || num.length == 0){
            return 0;
        }
        
        int len = num.length;
        if(len == 1){
            return num[0];
        }else{
          if(len == 2){
            return Math.min(num[0], num[1]);
         }
        }
    
        int left = 0;
        int right = len - 1;
        
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(num[left] < num[right]){
                return num[left];
            }
            
            if(num[left] < num[mid]){
                left = mid;
            }else if(num[mid] < num[left]){
                right = mid;
            }else{
                left++;
            }
        }
        return Math.min(num[left],num[right]);
    }
}