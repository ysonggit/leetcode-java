public class Solution {
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if(n==0 && m==0) return "";
        if(n==0) return b;
        if(m==0) return a;
        int i = n-1, j = m-1;
        int a_bit = 0, b_bit = 0, carry = 0;
        StringBuilder sum = new StringBuilder();
        while(i>=0 || j>=0){
            a_bit = (i<0) ? 0 : (int) a.charAt(i)-'0';
            b_bit = (j<0) ? 0 : (int) b.charAt(j)-'0';
            char a_plus_b =  ((a_bit + b_bit + carry )%2 == 0) ? '0' : '1';
            carry = (a_bit + b_bit + carry)/2;
            sum.insert(0, a_plus_b);
            j--;
            i--;
        }
        if(carry==1) sum.insert(0, '1');
        return sum.toString();
    }
}
