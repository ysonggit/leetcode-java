public class Solution {
    public int nthUglyNumber(int n) {
        int ugly_numbers [] = new int[n];
        ugly_numbers[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for(int i=1; i<n; i++){
            int ugly = Math.min(Math.min(ugly_numbers[p2]*2, ugly_numbers[p3]*3), ugly_numbers[p5]*5);
            ugly_numbers[i] = ugly;
            if(ugly/ugly_numbers[p2]==2) p2++; // mistake : / == 2 not % == 0
            if(ugly/ugly_numbers[p3]==3) p3++;
            if(ugly/ugly_numbers[p5]==5) p5++;
            
        }
        return ugly_numbers[n-1];
    }
}
