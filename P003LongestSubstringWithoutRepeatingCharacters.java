public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0) return 0;
        int max_len = 0;
        int count [] = new int [256];
        int front = 0, back = 0;
        while(back<n){
            int pos = (int) s.charAt(back);
            count[pos]++;
            while(count[pos]>1){
                while(front < back ){
                    count[(int) s.charAt(front)]--;
                    front++;
                    if(count[pos]==1) break;
                }
            }
            max_len = Math.max(max_len, back-front+1);
            back++;
        }
        return max_len;
    }
}
