/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int num = 0;
        boolean eof = false;
        while (!eof && num < n) {
            int size = read4(buffer);
            if (size < 4) {
                eof = true;
            }
            int bytes = Math.min(n - num, size);
            System.arraycopy(buffer, 0, buf, num, bytes);
            num += bytes;
        }
        return num;
    }
}