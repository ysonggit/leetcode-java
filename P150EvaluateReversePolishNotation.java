public class Solution {
    public boolean isOperator(String s){
        if(s.length()>1) return false;
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) return true;
        return false;
    }
    
    public int compute(Integer a, Integer b, String op){
        if(op.equals("+")) return a+b;  // do not use == to compare
        if(op.equals("-")) return a-b;
        if(op.equals("*")) return a*b;
        return a/b;
    }
    
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        if(n==0) return 0;
        Stack<Integer> num = new Stack<Integer>();
        for(String s : tokens){
            if(!isOperator(s)){
                num.push(Integer.valueOf(s));
            }else{
                Integer b = num.pop();
                Integer a = num.pop();
                num.push(compute(a, b, s));
            }
        }
        return num.peek();
    }
}
