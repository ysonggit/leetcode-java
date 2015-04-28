public class Solution {
    // M[i] : max amount of money by robbing first i houses
    // M[0] = 0
    // M[1] = nums[0]
    // for i> 1
    // M[i] = max(M[i-2] + rob_current_house, M[i-1])
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int M[] = new int[n+1];
        M[0] = 0;
        M[1] = nums[0];
        for(int i=2; i<=n; i++){
            int cur_house_money = nums[i-1];
            M[i] = Math.max(M[i-2]+cur_house_money, M[i-1]);
        }
        return M[n];
    }
}
