public class Solution {
    // idea : compare each segment (between dot) by converting them to long (overflow)
    public int compareVersion(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        if(n== 0 || m==0) return 0;
        int i=0, j=0;
        while(i<=n || j<=m){
            long a = 0, b=0;
            while(i<n && version1.charAt(i)!='.'){
                a = a * 10 + (int) (version1.charAt(i)-'0');
                i++;
            }
            i++; // important ! must skip dot, so next time can compute next segment 
            while(j<m && version2.charAt(j)!='.'){
                b = b * 10 + (int) (version2.charAt(j)-'0');
                j++;
            }
            j++; 
            if(a > b) return 1;
            if(a < b) return -1;
        }
        return 0;
    }
}
