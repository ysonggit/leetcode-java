public class Solution {
    public int mySqrt(int x) {
        if(x<2) return x;
        int low = 1, high = x;
        while(low<high){
            int mid = low+(high-low)/2;
            if(x/mid < mid){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return high-1;
    }
}
