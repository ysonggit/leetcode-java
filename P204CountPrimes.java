public class Solution {
    // sieve of eraosthenes
    public int countPrimes(int n) {
        if(n<2) return 0;
        boolean A[] = new boolean [n];
        Arrays.fill(A, true);
        for(int i=2; i<Math.sqrt(n); i++){
            if(A[i]==true){
                // erase i*i i*i+i i*i+2i... n
                for(int j=i*i; j<n; j+=i){
                    A[j] = false;
                } 
            }
        }
        int count=0;
        for(int i=2; i<n; i++){
            if(A[i]==true) count++;
        }
        return count;
    }
}
