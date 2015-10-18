public class Solution {
    // key: every time record min_of(citations[mid], n-mid)
    public int hIndex(int[] citations) {
        int n = citations.length;
        int front = 0, back = n-1, h = 0;
        while(front<=back){
            int mid = front+(back-front)/2;
            if(citations[mid] == n-mid){
                return citations[mid]; // do not return mid!
            }else if(citations[mid] < n-mid){
                h = citations[mid];
                front++; // can not use mid+1
            }else{
                h = n-mid;
                back--; 
            }
        }
        return h;
    }
}
