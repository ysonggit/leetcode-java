public class Solution {
    // 1 transpose matrix
    // 2 reverse each row
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n==0) return ;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){ // mistake : j=0
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<n; i++){
            int front = 0, back = n-1;
            while(front<back){
                int temp = matrix[i][back];
                matrix[i][back] = matrix[i][front];
                matrix[i][front] = temp;
                front++;
                back--;
            }
        }
    }
}
