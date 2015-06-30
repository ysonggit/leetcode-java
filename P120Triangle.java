public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==0) return 0;
        int[] sum_last_row = new int[n];
        if(triangle.get(0).size()==0) return 0;
        sum_last_row[0]=triangle.get(0).get(0);
        for(int i=1; i<n; i++){
            List<Integer> cur_row = triangle.get(i);
            for(int j=cur_row.size()-1; j>=0; j--){
                if(j==cur_row.size()-1){
                    sum_last_row[j] = cur_row.get(j)+sum_last_row[j-1];
                }else if(j==0){
                    sum_last_row[j] = cur_row.get(j)+sum_last_row[j];
                }else{
                    sum_last_row[j] = cur_row.get(j) + Math.min(sum_last_row[j], sum_last_row[j-1]);
                }
            }
        }
        int min_sum = sum_last_row[0];
        for(int i=1; i<n; i++){
            min_sum = Math.min(sum_last_row[i], min_sum);
        }
        return min_sum;
    }
}
