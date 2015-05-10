public class Solution {
    public String convertToTitle(int n) {
        if(n<=0) return "";
        StringBuilder title = new StringBuilder();
        while(n>0){
            int rem = n %26;
            if(rem!=0){
                char rightbit = (char) (rem-1+ (int)'A'); // mistake: can not + a number with a char
                title.insert(0, rightbit);
            }else{
                title.insert(0,'Z');
                n--; // important!
            }
            n /= 26;
        }
        return title.toString();
    }
}
