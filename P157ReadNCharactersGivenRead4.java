/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char temp[] = new char[4];
        int bytes_copied = 0;
        boolean eof = false;
        while(!eof && bytes_copied <n){
            int bytes_from_src = read4(temp);
            if(bytes_from_src < 4) eof = true;
            int bytes_to_copy = Math.min(n-bytes_copied, bytes_from_src);
            System.arraycopy(temp, 0, buf, bytes_copied, bytes_to_copy);
            bytes_copied += bytes_to_copy;
        }
        return bytes_copied;
    }
}
