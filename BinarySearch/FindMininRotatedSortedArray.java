public class Solution {
    public int findMin(int[] num) {
        if(num == null || num.length == 0){
            return 0;
        }
        
        if(num.length == 1){
            return num[0];
        }else if(num.length == 2){
            return Math.min(num[0],num[1]);
        }
        
        int l = 0;
        int r = num.length - 1;
        
        while(l < r - 1){
            int m = l + (r - l)/2;
            
            if(num[r] > num[l]){
                return num[0];
            }
            
            if(num[m] > num[l]){
                l = m;
            }else{
                r = m;
            }
        }
        
        return num[r];
    }
}