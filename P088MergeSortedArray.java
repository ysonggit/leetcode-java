public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if(n==0) return ;
        if(m==0) {
            // mistake : do not use A=B
            for(int i=0; i<n; i++){
                A[i]=B[i];
            }
            return;
        }
        int i = m-1, j=n-1, k=m+n-1;
        while(i>=0 || j>=0){
            if(i>=0 && j>=0){
                if(A[i]>B[j]){
                    A[k]=A[i];
                    i--;
                }else{
                    A[k]=B[j];
                    j--;
                }
            }else{
                if(j<0) return ;
                if(i<0){
                    A[k]=B[j];
                    j--;
                }
            }
            k--;
        }
        
    }
}
