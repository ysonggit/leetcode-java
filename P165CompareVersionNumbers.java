public class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] = (version1.concat(".")).split("\\."); // mistake: must use \\.
        String v2[] = (version2.concat(".")).split("\\.");
        int val1 = 0, val2 = 0;
        int i=0, j=0;
        System.out.println(v1.length+" + "+v2.length);
        while(i<v1.length || j<v2.length){
            val1 = (i<v1.length) ? Integer.valueOf(v1[i]) : 0;
            val2 = (j<v2.length) ? Integer.valueOf(v2[j]) : 0;
            if(val1>val2) return 1;
            else if(val1<val2) return -1;
            else{
                i++;
                j++;
            }
        }
        return 0;
    }
}
