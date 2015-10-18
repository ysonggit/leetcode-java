public class Solution {
    /*
        strobogrammatic number features:
        1. composed of: 1 6 9 8 0
        2. symmetric on 1, 8, 0
    */
    HashMap<Character, Character> table = new HashMap<Character, Character>()
    {
        {   
            put('0','0');
            put('1','1');
            put('6','9');
            put('9','6');
            put('8','8');
        }    
    }; 
    public boolean isStrobogrammatic(String num) {
        int n = num.length();
        if(n==0) return false;
        int front = 0, back = n-1;
        while(front<=back){
            char c_f = num.charAt(front);
            char c_b = num.charAt(back);
            if(!table.containsKey(c_f) || !table.containsKey(c_b)) return false;
            if(table.get(c_f)!=c_b) return false;
            front++;
            back--;
        }
        return true;
    }
}
