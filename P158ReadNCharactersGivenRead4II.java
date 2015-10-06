/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     * official solution
     */
    char cache [] = new char[4];
    int offset = 0, bufsize = 0;
    public int read(char[] buf, int n) {
        boolean eof = false;
        int bytes_copied = 0;
        while(!eof && bytes_copied<n){
            if(bufsize ==0){
                bufsize = read4(cache);
                eof = bufsize<4;
            }
            int bytes_to_copy = Math.min(n-bytes_copied, bufsize);
            System.arraycopy(cache, offset, buf, bytes_copied, bytes_to_copy);
            bytes_copied += bytes_to_copy;
            offset = (offset + bytes_to_copy) % 4;
            bufsize -= bytes_to_copy;
        }
        return bytes_copied;
    }
}
