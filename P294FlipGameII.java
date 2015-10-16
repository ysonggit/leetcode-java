public class Solution {
    // typical solution: recusion
    public boolean canWin(String s) {
        int n = s.length();
        if(n<2) return false;
        for(int i=0; i<n-1; i++){
            if(s.charAt(i)==s.charAt(i+1) && s.charAt(i)=='+'){
                String next = s.substring(0,i)+"--"+s.substring(i+2);
                if(!canWin(next)){
                    return true;
                }
            }
        }
        return false;
    }
}
