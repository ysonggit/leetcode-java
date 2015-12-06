public class Solution {
    // recursive (brute-force) 
    int [][] cache; // memorization to pass TLE
    public int maxSum(int[] nums, int i, int j){
        if(cache[i+1][j]>=0) return cache[i+1][j];
        if(i>j) return 0;
        int n = nums.length;
        int max_sum = 0; 
        for(int k=i+1; k<j; k++){
            int left = (i==-1) ? 1 : nums[i];
            int right = (j==n) ? 1 : nums[j];
            int local =  maxSum(nums, i, k)+maxSum(nums, k, j)+left*nums[k]*right;
            if(max_sum < local){
               max_sum = local;
            }
        }
        cache[i+1][j]= max_sum;
        return max_sum;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        cache = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++) cache[i][j]=-1;
        }
        return maxSum(nums, -1, n);
    }
}

public class Solution {
    // DP
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
