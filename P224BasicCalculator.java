public class Solution {
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
