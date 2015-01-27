public class Solution {
    public double pow(double x, int n) {
        if(x == 0){
            return 0;
        }
        
        if(x == 1|| n == 0){
            return 1;
        }
        
        if(n < 0){
            double ret1 = x * pow(x, -(1 + n));
            return 1/(double)ret1;
        }
        
        int m = n%2;
        
        double ret = pow(x, n/2);
        ret *= ret;
        if(m == 1){
            ret *= x;
        }
        
        return ret;
    }
}