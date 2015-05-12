public class Solution {
    public boolean isPalindrome(String s){
        int front = 0, back = s.length()-1;
        while(front<back){
            if(s.charAt(front) != s.charAt(back)) return false;
            front++;
            back--;
        }
        return true;
    }
    
    public void dfs(List<List<String>> res, String s, ArrayList<String> sol, int cur_idx){
        if(cur_idx == s.length()){
            List<String> path = new ArrayList<String>(sol);
            res.add(path);
            return;
        }
        for(int len=1; len<=s.length()-cur_idx; len++){
            String candidate = s.substring(cur_idx, cur_idx+len);
            if(isPalindrome(candidate)){
                sol.add(candidate);
                dfs(res, s, sol, cur_idx+len);
                sol.remove(sol.size()-1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        int n = s.length();
        if(n==0) return res;
        ArrayList<String> sol = new ArrayList<String>();
        dfs(res, s, sol, 0);
        return res;
    }
}
