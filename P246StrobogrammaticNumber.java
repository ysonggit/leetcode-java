public class Solution {
    /*
        strobogrammatic number features:
        1. composed of: 1 6 9 8 0
        2. symmetric on 1, 8, 0
        3. 
    */
    public boolean isStrobogrammaticDigit(char c){
        if(c=='6'||c=='9'|| c=='8'||c=='1'||c=='0') return true;
        return false;
    }
    // assume input is either 0/1/8/6/9
    public boolean isStrobogrammaticPair(char a, char b){
        if (a=='0' || a=='1' || a=='8') return a==b;
        if(a=='6') return b=='9';
        if(a=='9') return b=='6';
        return false;
    }
    public boolean isStrobogrammatic(String num) {
        int n = num.length();
        if(n==0) return false;
        int front = 0, back = n-1;
        while(front<=back){ // mistake: should not use < , "2"
            char c_f = num.charAt(front);
            char c_b = num.charAt(back);
            if(!isStrobogrammaticDigit(c_f) || !isStrobogrammaticDigit(c_b)) return false;
            if(!isStrobogrammaticPair(c_f, c_b)) return false;
            front++;
            back--;
        }
        return true;
    }
}
