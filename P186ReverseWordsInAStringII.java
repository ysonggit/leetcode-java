public class Solution {
    public void reverseInplace(char[] s, int start, int end){
        while(start<end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
    public void reverseWords(char[] s) {
        int n = s.length;
        if(n==0) return;
        int i = 0, start = 0, end=0;
        reverseInplace(s, 0, n-1);
        while(i<n){
            while(i<n && s[i]!=' ') i++; //mistake: don't forget i<n!
            end = i-1;
            reverseInplace(s, start, end);
            start = i+1;
            i++;
        }
    }
}
