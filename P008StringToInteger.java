public class Solution {
    // sign
    // overflow
    // space ?
    public int myAtoi(String str) {
        str = str.trim();
        int n=str.length();
        if(n==0) return 0;
        int i=0, sign = 1;
        if(str.charAt(0) == '-') {
            sign=-1;
            i++;
            if(!Character.isDigit(str.charAt(i) )) return 0; // mistake +- return 0
        }
        if(str.charAt(0) == '+'){
            i++;
            if(!Character.isDigit(str.charAt(i) )) return 0;
        } 
        
        int res = 0;
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        while(i<n){
            char cur = str.charAt(i);
            if(!Character.isDigit(cur)) return sign * res; // mistake -0012a4 return -12
            int c =(int) cur -'0';
            // overflow check 
            if((res > MAX/10 ) || (res== MAX/10 && c > MAX%10)){
                return (sign>0) ? MAX : MIN;
            }
            res = res * 10 + c;
            i++;
        }
        return sign * res;
    }
}
