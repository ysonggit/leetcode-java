class Solution {
    public double myPow(double x, int n) { // overflow issue? YES!
        long m = (long) n;
        if (m<0){
            x = 1.0/x;
            m = -m; // tricky. when n = -2147483648, -n is overflow
        }
        double res = 1.0;
        while(m>0){
            if (m%2==1){
                res *= x;
            }
            x *= x;
            m >>= 1;
        }
        return res;
    }
}
