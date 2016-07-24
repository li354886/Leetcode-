/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int mid = (n+low)/2;
        int g = guess(mid);
        while(g != 0) {
            if(g > 0) {
                low = mid + 1;
            } else {
                n = mid-1;
            }
            mid = (int)((double)n/2+(double)low/2);
            g = guess(mid);
        }
        
        return mid;
    }
}