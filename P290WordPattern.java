public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String strs [] = str.split(" ");
        if(strs.length != pattern.length()) return false;
        Map<Character, String> forward_map = new HashMap<Character, String>();
        Map<String, Character> backward_map = new HashMap<String, Character>();
        for(int i = 0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            String s = strs[i];
            if(!forward_map.containsKey(c)){
                forward_map.put(c, s);
            }else{
                if(!forward_map.get(c).equals(s)) return false;
            }
            if(!backward_map.containsKey(s)){
                backward_map.put(s, c);
            }else{
                if(!backward_map.get(s).equals(c)) return false;
            }
        }
        return true;
    }
}
