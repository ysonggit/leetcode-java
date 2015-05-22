public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i =0; i<(1<<n); i++){
            int gc = (i>>1) ^ i;
            res.add(gc);
        }
        return res;
    }
}
