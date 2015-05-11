public class Solution {
    class Cmp implements Comparator<String>{
        public int compare(String a, String b){
            // descending order : return b-a
            if( Long.valueOf(b+a) > Long.valueOf(a+b) ) return 1; // mistake : Integer.valueOf(b+a)- Integer.valueOf(a+b) overflow
            return -1;
        }
    }
    public String largestNumber(int[] nums) {
        int n = nums.length;
        if(n==0) return "";
        String [] numstrs = new String[n];
        for(int i=0; i<n; i++){
            numstrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numstrs, new Cmp());
        StringBuilder res = new StringBuilder();
        for(String s: numstrs){
            res.append(s);
        }
        // note: 0001 -> 1 || 00000 -> 0
        int j=0;
        int m=res.length();
        while(j<m-1 && res.charAt(j)=='0') j++;
        return res.substring(j);
    }
}
