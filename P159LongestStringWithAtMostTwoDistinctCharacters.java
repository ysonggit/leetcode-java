public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if(n<=2) return n;
        int num_distincts = 0, start_pos = 0;
        int max_len = 0;
        int count[] = new int[256];
        for(int k=0; k<n; k++){
            char cur = s.charAt(k);
            if(count[(int)cur]==0) num_distincts++;
            count[(int)cur]++;
            while(num_distincts > 2){
                // move startpos forward while reducing char count passed by
                char c = s.charAt(start_pos);
                count[((int)c)]--;
                if(count[((int)c)]==0) num_distincts--;
                start_pos++;
            }
            max_len = Math.max(max_len, k-start_pos+1);
        }
        return max_len;
    }
}
