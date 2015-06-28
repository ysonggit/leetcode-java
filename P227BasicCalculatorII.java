public class Solution {
    /*
        two stacks:
        stack 1 saves only +/- stack2 saves number to be computed
        3+2*2
           stack1 stack2
        3            3
        +   +        3
        2   +        3,2
        *   +        3,2 look ahead
        2   +        3,4
        end 
        clear stacks => 7
                     
        3+2*2-20/5*3
           stack1 stack2
        3            3
        +   +        3
        2   +        3,2
        *   +        3,2 look ahead
        2   +        3,4
        -   +,-      3,4
        20  +,-      3,4,20
        /   +,-      3,4,20 look ahead
        5   +,-      3,4,4
        *   +,-      3,4,4 look ahead
        3   +,-      3,4,12
        end 
        clear stacks 3+4-12 = -5
    */
    public int calculate(String s) {
        int n =s.length();
        if(n==0) return 0;
        Stack<Character> ops = new Stack<Character>();
        Stack<Integer> nums = new Stack<Integer>();
        int i= 0;
        while(i<n){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                int num = 0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    num= num*10 + (int)(s.charAt(i)) - (int)'0';
                    i++;
                    if(i==n){
                        break;
                    }
                }
                nums.push(num);
            }else if(cur ==' '){
                i++;
            }else{
                // operators
                if(cur=='+' || cur=='-'){
                    ops.push(cur);
                    i++;
                }else{
                    // * or /
                    i++;
                    while(i<n && s.charAt(i)==' ') i++;
                    // must be a number ahead
                    int num_ahead = 0;
                    while(i<n && Character.isDigit(s.charAt(i))){
                        num_ahead = num_ahead *10 + (int)(s.charAt(i)) - (int)'0';
                        i++;
                        if(i==n){
                            break;
                        }
                    }
                    if(cur == '*') nums.push(nums.pop() * num_ahead);
                    else nums.push(nums.pop() / num_ahead);
                }
            }
        }
        Stack<Character> rev_ops = new Stack<Character>();
        Stack<Integer> rev_nums = new Stack<Integer>();
        while(!ops.empty()){
            rev_ops.push(ops.pop());
        }
        while(!nums.empty()){
            rev_nums.push(nums.pop());
        }
        while(!rev_ops.empty()){
            int a = rev_nums.pop();
            int b = rev_nums.pop();
            char op = rev_ops.pop();
            if(op == '+') rev_nums.push(a+b);
            else rev_nums.push(a-b);
        }
        return rev_nums.peek();
    }
}
