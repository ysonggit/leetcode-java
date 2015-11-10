public class Solution1 {
    /*
    solution from victorlee:
    two stacks, stack1 saves operators: ) and +/-, stack2 saves numbers
    scan expression from right to left
        (4-(3-2))
        stack1  stack2
        )
        ))
                 2
        ))-         
                 2,3
                 
        )        1
        )-
                 1,4
                 3
    */
    public void compute(Stack<Character> operators, Stack<Integer> operands){
        Integer a = operands.pop();
        Integer b = operands.pop();
        Character op = operators.pop();
        if(op == '+') operands.push(a+b);
        else operands.push(a-b);
    }
    public int calculate(String s) {
        String expr = s.replaceAll("\\s", ""); // XD
        int n = expr.length();
        int i= n-1;
        Stack<Character> operators = new Stack<Character>();
        Stack<Integer> operands = new Stack<Integer>();
        while(i>=0){
            char cur = expr.charAt(i);
            if(Character.isDigit(cur)){
                StringBuffer token = new StringBuffer();
                while(Character.isDigit(expr.charAt(i))){
                    token.insert(0,expr.charAt(i)); // prepend char !!
                    i--;
                    if(i<0) break; // mistake
                }
                operands.push(Integer.valueOf(token.toString()));
            }else if (cur == '('){ // compute expression
                while(operators.peek()!=')' && operators.size()>1) { // (1)
                   compute(operators, operands);
                }
                operators.pop(); // expression in one pair of () is computed, pop ')'
                i--;
            }else{ // push )/+/- to stack
                operators.push(cur);
                i--;
            }
        }
        while(!operators.empty()) compute(operators, operands);
        return operands.peek();
    }
}

public class Solution2 {
    public int calculate(String s) {
        int res = 0, num = 0, sign = 1;
        Stack<Integer> ops = new Stack<Integer>();
        Stack<Integer> sums = new Stack<Integer>();
        for(char c : s.toCharArray()){
            if(c==' ') continue;
            else if(Character.isDigit(c)){ // assume no overflow happens
                num = num * 10 + (int)(c-'0');
            }else{
                // evaluate expr locally
                res += sign * num;
                num = 0;
                if(c=='+') sign= 1;
                if(c=='-') sign=-1;
                if(c=='('){
                    sums.push(res);
                    ops.push(sign);
                    sign = 1;
                    res = 0;
                }
                if(c==')' && !ops.empty()){
                    res = sums.pop() + ops.pop() * res;
                }
            }
        }
        return res + sign * num; // 8
    }
}
