public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        if(m==0) return new int[0][0];
        int n = A[0].length, k = B[0].length;
        int [][] res = new int [m][k];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //for(int l=0; l<k; l++){
                //    if(A[i][j]!=0) res[i][l] += A[i][j] * B[j][l];
                //}
                if(A[i][j]!=0) {
                    for(int l=0; l<k; l++){
                        res[i][l] += A[i][j] * B[j][l];
                    }
                }
            }
        }
        return res;
    }
}
