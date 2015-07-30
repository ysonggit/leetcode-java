public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        if(strs.length == 0) return res;
        HashMap<String, ArrayList<String>> ana_map = new HashMap<String, ArrayList<String>>();
        for(String s : strs){
            char s_char [] = s.toCharArray();
            Arrays.sort(s_char);
            String key = new String(s_char);
            if(!ana_map.containsKey(key)){
                ArrayList<String> vals = new ArrayList<String>();
                vals.add(s);
                ana_map.put(key, vals);
            }else{
                ana_map.get(key).add(s);
            }
        }
        for(Map.Entry<String, ArrayList<String>> entry : ana_map.entrySet()){
            if(entry.getValue().size()>1){
                for(String s : entry.getValue()){
                    res.add(s);
                }
            }
        }
        return res;
    }
}
