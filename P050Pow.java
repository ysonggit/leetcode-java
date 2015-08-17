public class Solution {
    /*
        y = (n%2==1) ? x : 1
        x^n = x^(n/2) * x^(n/2) * y
        n could be negative
        corner case: x = -1.0 or x = 1.0
    */
    public double myPow(double x, int n) {
        if(n==0) return 1.0;
        if(n==1) return x;
        if(Double.compare(x, 1.0) == 0) return 1.0;
        if(Double.compare(x, -1.0) ==0) return (n%2==1) ? x : 1.0;
        if(n<0) return 1.0/myPow(x, -n);
        double y = (n%2==1) ? x : 1;
        double z = myPow(x, n/2);
        return z * z * y;
    }
}
