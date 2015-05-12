public class Solution {
    public void dfs(List<String> res,  String digits, StringBuilder sol, int cur_idx, HashMap<Character, String> letters){
        if(cur_idx == digits.length()) {
            res.add(sol.toString());
            return;
        }
        String candidates = letters.get(digits.charAt(cur_idx));
        for(int i=0; i<candidates.length(); i++){
            sol.append(candidates.charAt(i));
            dfs(res, digits, sol, cur_idx+1,  letters);
            sol.deleteCharAt(sol.length()-1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits.length()==0) return res;
        HashMap<Character, String> letters = new HashMap<Character, String>();
        String combs[] = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i='0'; i<='9'; i++){
            letters.put((char)i, combs[i-'0']);
        }
        StringBuilder sol = new StringBuilder();
        dfs(res, digits, sol, 0, letters);
        return res;
    }
}
