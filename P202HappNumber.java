public class Solution {
    // idea use hashmap to cache computed bits
    // given only positive numbers
    HashMap<Integer, Integer> cache = new HashMap<>();
    public boolean isHappy(int n) {
        if(n==1) return true;
        int sum = 0;
        while(n>0){
            sum += Math.pow(n%10, 2);
            n /=10;
        }
        if(cache.containsKey(sum) ) return false;
        cache.put(sum, 1);
        return isHappy(sum);
    }
}
