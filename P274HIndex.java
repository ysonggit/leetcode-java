public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length, h = 0;
        // h-index (f) = \max_i \min (f(i), i)
        for(int i=0; i<n; i++){
            h = Math.max(h, Math.min(citations[i], n-i));
        }
        return h;
    }
}
