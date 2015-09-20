public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0) return false;
        int n = matrix[0].length;
        int low = 0, high = m * n;
        while(low<high){
            int mid = low+(high-low)/2;
            // row major order index
            int i= mid/n, j = mid%n;
            if(target == matrix[i][j]){
                return true;
            }else if(target < matrix[i][j]){
                high = mid; // mistake: not mid-1
            }else{
                low = mid+1;
            }
        }
        return false;
    }
}
