public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n==0) return "";
        StringBuilder prefix = new StringBuilder();
        int m = strs[0].length();
        for(int pos=0; pos<m; pos++){
            char cur = strs[0].charAt(pos);
            for(int i=1; i<n; i++){
                String s = strs[i];
                if(pos>=s.length()) {
                    return prefix.toString();
                }else{
                    if(s.charAt(pos)!=cur){
                        return prefix.toString();
                    }
                }
            }
            // now every other one has the same char cur
            prefix.append(cur);
        }
        return prefix.toString();
    }
}
