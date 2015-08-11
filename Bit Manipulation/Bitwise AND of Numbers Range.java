public class Solution {
    //找左边共同部分
    public int rangeBitwiseAnd(int m, int n) {
        int d = Integer.MAX_VALUE;
        while ((m & d) != (n & d)) {
            d = d << 1;
        }
        return m & d;
    }
}