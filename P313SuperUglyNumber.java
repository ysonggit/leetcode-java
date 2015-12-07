public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1) return 1;
        int k = primes.length;
        int [] L = new int[k]; // array of indices 
        int [] super_ugly = new int [n];
        super_ugly[0] = 1;
        for(int i=1; i<n; i++){
            int ugly = Integer.MAX_VALUE;
            for(int j=0; j<k; j++){
                ugly = Math.min(ugly, super_ugly[L[j]]* primes[j]);
            }
            super_ugly[i] = ugly;
            // update min ugly's index
            for(int j=0; j<k; j++){
                if(ugly%primes[j]==0) L[j]++;
            }
        }
        return super_ugly[n-1];
    }
}
