public class Solution {
    // key: every time record min_of(citations[mid], n-mid)
    public int hIndex(int[] citations) {
        int n = citations.length;
        int front = 0, back = n-1;
        while(front<=back){
            int mid = front+(back-front)/2;
            if(citations[mid] < n-mid){
                front = mid+1;
            }else{
                back = mid-1; 
            }
        }
        return n-front;
    }
}
