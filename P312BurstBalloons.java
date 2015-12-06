public class Solution {
    // similar to Matrix Chain Multiplication
    public int maxCoins(int[] nums) {
        int [] A = new int[nums.length+2];
        for(int i=1; i<=nums.length; i++){
            A[i] = nums[i-1];
        }
        A[0] = A[nums.length+1] = 1;
        int n = A.length;
        int [][] D = new int[n][n];
        for(int len=2; len<n; len++){
            for(int start = 0; start<n-len; start++){
                int end = start + len;
                for(int k=start+1; k<end; k++){
                    int local = D[start][k] + D[k][end] + A[start]*A[k]*A[end];
                    D[start][end] = Math.max(D[start][end], local);
                }
            }
        }
        return D[0][n-1];
    }
}
