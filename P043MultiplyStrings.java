public class Solution {
    /**
     * for a[0..n-1] and b[0..m-1]
     * r[i] is the i~th digit of the product from right to left
     * r[i] = carry + sum_of(a[j] * b[k])
     *                j+k = i
     * 
     */ 
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int n = len1 + len2;
        int prod[] = new int[n];
        String mul1 = new StringBuilder(num1).reverse().toString();
        String mul2 = new StringBuilder(num2).reverse().toString();
        // multiply from right to left
        for(int j=0; j<len1; j++){
            int a = mul1.charAt(j)-'0';
            for(int k=0; k<len2; k++){
                int b = mul2.charAt(k)-'0';
                prod[j+k] += a * b;
                prod[j+k+1] += prod[j+k] / 10; // mistake : prod[i+j] != a*b! compute carryout for next bit
                prod[j+k] %= 10;
            }
        }
        // pass by initial zeros
        int i = n-1;
        while(i>=0 && prod[i]==0) i--;
        StringBuilder res = new StringBuilder();
        for(; i>=0; i--){
            res.append(prod[i]);
        }
        return (res.length()==0) ? "0" : res.toString();
    }
}
