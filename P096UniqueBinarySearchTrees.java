public class Solution {
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public int numTrees(int n) {
        if(n<=1) return 1;
        if(cache.containsKey(n)) return cache.get(n);
        int num = 0;
        for(int i=1; i<=n; i++){
            num += numTrees(i-1) * numTrees(n-i);
        }
        cache.put(n, num);
        return num;
    }
}
