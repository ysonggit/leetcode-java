public class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> val_count = new HashMap<Integer, Integer>();
        for(int i : nums){
            if(val_count.containsKey(i)){
                val_count.put(i, 2);
            }else{
                val_count.put(i, 1);
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> entry: val_count.entrySet()){
            if(entry.getValue()==1){
                res.add(entry.getKey());
            }
        }
        int singles[] = {res.get(0), res.get(1)};
        return singles;
    }
}
