public class Solution {
    // generate next seq given current one
    public String generateNext(String cur){
        StringBuilder next = new StringBuilder();
        int i=0, n = cur.length(); 
        while(i<n){
            int j=i+1;
            int count = 1;
            while(j<n && cur.charAt(j) == cur.charAt(i)){
                j++;
                count++;
            }
            next.append(String.valueOf(count));
            next.append(cur.charAt(i));
            i=j;  // smart ! Don't use i++
        }
        return next.toString();
    }
    public String countAndSay(int n) {
        if(n==0) return "";
        if(n==1) return "1";
        String cur = "1";
        for(int i=2; i<=n; i++){
            cur = generateNext(cur);
        }
        return cur;
    }
}
