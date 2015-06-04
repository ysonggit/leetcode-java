public class Solution {
    // (())(())
    // key: use stack to save the positions of unmatched left parentheses 
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n==0) return 0;
        int max_len = 0; 
        int last_right_paren_pos = -1; // trick
        Stack<Integer> left_parens_pos = new Stack<Integer>();
        for(int i=0; i<n; i++){
            char cur = s.charAt(i);
            if(cur == '('){
                left_parens_pos.push(i);
            }else{
                // ')' determine the length of valid parentheses pair 
                if(left_parens_pos.empty()){
                    last_right_paren_pos = i;
                }else{
                    left_parens_pos.pop();
                    if(left_parens_pos.empty()){
                        max_len = Math.max(max_len, i-last_right_paren_pos);
                    }else{
                        max_len = Math.max(max_len, i-left_parens_pos.peek());
                    }
                }
            }
        }
        return max_len;
    }
}
