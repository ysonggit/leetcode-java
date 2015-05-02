public class Solution {
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {
        if(n<=2) return n;
        if(cache.containsKey(n)) return cache.get(n);
        int num_ways = climbStairs(n-1)+climbStairs(n-2);
        cache.put(n, num_ways);
        return num_ways;
    }
}
