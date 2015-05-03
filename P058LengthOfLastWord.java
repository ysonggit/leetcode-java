public class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        if(n==0) return 0;
        int back = n-1;
        while(back>=0 && s.charAt(back) == ' ') back--;
        if(back<0) return 0; // all spaces
        int len = 0;
        while(back>=0 && s.charAt(back) != ' '){
            back--; 
            len++;
        } 
        return len;
    }
}
