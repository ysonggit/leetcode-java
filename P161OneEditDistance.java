public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if(s.equals(t)) return false; // important
        if(m > n) return isOneEditDistance(t, s);
        if(n-m>1) return false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                char [] t_arr = t.substring(i+1).toCharArray();
                if(m==n) {
                    char [] s_arr = s.substring(i+1).toCharArray();
                    return Arrays.equals(s_arr, t_arr); // use array equals to bypass TLE; seems str.equals takes too long time
                }else{
                    char [] s_arr = s.substring(i).toCharArray();
                    return Arrays.equals(s_arr, t_arr); //abc acbc
                } 
            }
        }
        return true; // "a", ""
    }
}
