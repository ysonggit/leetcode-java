public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        int n= s.length();
        List<String> res = new ArrayList<String>();
        if(n<2) return res;
        for(int i=0; i<n-1; i++){
            if(s.charAt(i)==s.charAt(i+1) && s.charAt(i)=='+'){
                String flip = s.substring(0, i) + "--" + s.substring(i+2, n);
                res.add(flip);
            }
        }
        return res;
    }
}
