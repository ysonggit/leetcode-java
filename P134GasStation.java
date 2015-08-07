public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int local_sum=0, global_sum=0, start_idx = 0;
        for(int i=0; i<n; i++){
            int rest = gas[i] - cost[i];
            global_sum += rest;
            local_sum += rest;
            if(local_sum < 0){
                start_idx = i+1;
                local_sum = 0;
            }
        }
        return global_sum < 0 ? -1 : start_idx;
    }
}
