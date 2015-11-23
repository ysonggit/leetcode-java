import java.math.BigInteger;
public class Solution {
    public boolean dfs(String num, ArrayList<BigInteger> seq, int start){
        if(start>=num.length()){
            return seq.size() >=3 ? true : false;
        }
        for(int i=start; i<num.length(); i++){
            if(i>start && num.charAt(start)=='0') break;
            String s = num.substring(start, i+1);
            BigInteger cur = new BigInteger(s);
            int n = seq.size();
            if(n<2||(n>=2 && cur.equals(seq.get(n-1).add(seq.get(n-2)))) ){
                seq.add(cur);
                if(dfs(num, seq, i+1)) return true;
                else seq.remove(seq.size()-1);
            }
        }
        return false;
    }
    public boolean isAdditiveNumber(String num) {
        if(num.isEmpty()) return false;
        ArrayList<BigInteger> seq = new ArrayList<BigInteger>();
        return dfs(num, seq, 0);
    }
}
