public class Solution {
    // from abner
    public int calculate(String s) {
        int n = s.length();
        if(n==0) return 0;
        int res = 0, num = 0;
        char sign = '+';
        String expr = s+"+"; //trick 
        Stack<Integer> operands = new Stack<Integer>();
        for(char c : expr.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + (int)(c-'0');
            }else{
                if(c==' ') continue;
                else {
                    if(sign=='+') operands.push(num);
                    if(sign=='-') operands.push(-1*num);
                    if(sign=='*') operands.push(operands.pop() * num);
                    if(sign=='/') operands.push(operands.pop() / num);
                    sign = c; // save the sign, to use in next round
                    num = 0;  
                }
            }
        }
        for(int i : operands){
            res += i;
        }
        return res;
    }
}
