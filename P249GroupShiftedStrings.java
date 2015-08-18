public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> groups = new ArrayList<List<String>>();
        if(strings.length==0) return groups;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strings){
            if(s.length()==0) continue;
            int offset_to_a = (int)(s.charAt(0) - 'a');
            // find key : each char minus offset_to_a
            StringBuilder k = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                char char_in_key = (char)( (int)c - offset_to_a);
                if(char_in_key<(int)'a') char_in_key = (char)((int)char_in_key + 26); 
                k.append(char_in_key);
            }
            String key = k.toString();
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
                List<String> new_group = new ArrayList<String>();
                new_group.add(s);
                map.put(key, new_group);
            }
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            List<String> g = entry.getValue();
            Collections.sort(g);
            groups.add(g);
        }
        return groups;
    }
}
