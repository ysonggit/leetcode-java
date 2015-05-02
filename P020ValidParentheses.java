public class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n==0) return true;
        Stack<Character> parens = new Stack<Character>();
        for(int i=0; i<n; i++){
            char cur = s.charAt(i);
            if(cur=='(' || cur=='[' || cur=='{'){
                parens.push(cur);
            }else{
                if(parens.empty()) return false;
                Character top = parens.peek();
                if((top == '(' && cur ==')')||(top== '[' && cur ==']')||(top== '{' && cur =='}')){
                    parens.pop();
                }else{
                    return false;
                }
            }
        }
        return parens.empty() ? true : false;
    }
}
