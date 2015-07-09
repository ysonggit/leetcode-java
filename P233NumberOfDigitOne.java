public class Solution {
    /*
    http://blog.csdn.net/u013027996/article/details/17126977
    if current bit is 0, the number of ones = highNum * base
    if current bit is 1,                    = highNum * base + lowNum + 1
    otherwise                               = (highNum + 1) * base
    */
    public int countDigitOne(int n) {
        if(n<=0) return 0;
        String num = String.valueOf(n);
        int count = 0;
        int base = 1;
        for(int i=num.length()-1; i>=0; i--){
            char cur = num.charAt(i);
            int highNum = (i==0) ? 0: Integer.valueOf(num.substring(0, i));
            int lowNum = (i==num.length()-1)? 0: Integer.valueOf(num.substring(i+1));
            if(cur == '0'){
                count+= highNum * base;
            }else if (cur=='1'){
                count+= highNum * base + lowNum + 1;
            }else{
                count+= (highNum+1)* base;
            }
            base *=10;
        }
        return count;
    }
}
