public class Solution {
    // n = 1, {0 1 8}
    // n = 2, {11 69 88 96}
    // n = 3, {101 111 181 609 619 689 808 818 888 906 916 986}
    public List<String> trickyRecur(int n, int final_n){
        if(n==0) return Arrays.asList("");
        if(n==1) return Arrays.asList("0", "1", "8");
        List<String> res = new ArrayList<String>();
        for(String num : trickyRecur(n-2, final_n)){
            // special case : 1001 or 10001
            if(final_n!=n) res.add("0"+num+"0");
            res.add("1"+num+"1");
            res.add("6"+num+"9");
            res.add("8"+num+"8");
            res.add("9"+num+"6");
        }
        Collections.sort(res);
        return res;
    }
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<String>();
        if(n<0) return res;
        return trickyRecur(n, n);
    }
}
