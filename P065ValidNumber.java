public class Solution {
    // official solution
    public boolean isNumber(String s) {
        s = s.trim();
        int i=0, n=s.length();
        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')) i++;
        boolean is_num = false;
        while(i<n && Character.isDigit(s.charAt(i))){
            i++;
            is_num = true;
        }
        if(i<n && s.charAt(i)=='.'){
            i++;
            while(i<n && Character.isDigit(s.charAt(i))){
                i++;
                is_num=true;
            }
        }
        if(is_num && i<n && s.charAt(i)=='e'){
            i++;
            is_num = false;
            if(i<n && (s.charAt(i)=='+'||s.charAt(i)=='-')) i++;
            while(i<n && Character.isDigit(s.charAt(i))){
                i++;
                is_num = true;
            }
        }
        return is_num && i==n;
    }
}
