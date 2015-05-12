public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n==0) {
            res.add("");
            return res;
        }
        if(n==1) {
            res.add("()");
            return res;
        }
        for(int i=0; i<n; i++){
            for(String inner : generateParenthesis(i)){
                for(String  outer : generateParenthesis(n-i-1)){
                    res.add(new String("("+inner+")"+outer));
                }
            }
        }
        return res;
    }
}
