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
/**
 * official solution
 public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, max_len = 0;
        int count [] = new int [256];
        Arrays.fill(count, -1);
        for(int j=0; j<s.length(); j++){
            if(count[s.charAt(j)]>=i){
                i= count[s.charAt(j)]+1;
            }
            count[s.charAt(j)] = j;
            max_len = Math.max(max_len, j-i+1);
        }
        return max_len;
    }
}
*/

