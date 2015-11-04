public class Solution {
    // from jeantimex
    public boolean isValid(String s){
        if(s.isEmpty()) return true;
        Stack<Character> parens = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c=='(') parens.push(c);
            else if(c==')') {
                if(parens.empty()) return false;
                else parens.pop();
            }else continue;
        }
        return parens.empty() ? true : false;
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        HashSet<String> visited = new HashSet<String>();
        Queue<String> Q = new LinkedList<String>();
        Q.offer(s);
        Q.offer(null);
        int max_len = 0;
        while(!Q.isEmpty()){
            String cur = Q.poll();
            if(cur == null) {
                if(max_len>0) { // found solution // truncate otherwise TLE
                    break;
                }
                if(!Q.isEmpty()) Q.offer(null);
            }else{
                if(isValid(cur)){
                    if(cur.length()>=max_len) res.add(cur);
                    max_len = Math.max(max_len, cur.length());
                }
                for(int i=0; i<cur.length(); i++){
                    String next = cur.substring(0, i) + cur.substring(i+1);
                    if(!visited.contains(next)){
                        Q.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return res;
    }
}
