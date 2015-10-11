public class Solution {
    Map<Character, String> forward_mapping;
    Map<String, Character> backward_mapping;
    public boolean isMatch(String pattern, String str,
                            int start_pattern, int start_str)
    {
        if(start_pattern==pattern.length() && start_str == str.length()) return true;
        if(start_pattern==pattern.length() || start_str == str.length()) return false;
        char pc = pattern.charAt(start_pattern);
        if(forward_mapping.containsKey(pc)){
            String pre_matched = forward_mapping.get(pc);
            if(start_str+pre_matched.length()> str.length()) return false;
            String cur = str.substring(start_str, start_str + pre_matched.length());
            if(cur.equals(pre_matched))
                return isMatch(pattern, str, start_pattern + 1, start_str+pre_matched.length());
            else
                return false;
        }else{
            for(int len=1; len<=str.length()-start_str; len++){
                String s = str.substring(start_str, start_str+len);
                if(backward_mapping.containsKey(s)){
                    continue;
                }
                forward_mapping.put(pc, s);
                backward_mapping.put(s, pc);
                         
                if(forward_mapping.get(pc)!=s){
                    continue; // not return false
                }
                    
                if(isMatch(pattern, str, start_pattern+1, start_str+len))
                    return true;
                forward_mapping.remove(pc);
                backward_mapping.remove(s);

            }
        }
        return false;
    }
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern.length()==0) return str.length()==0 ? true : false;
        forward_mapping = new HashMap<Character, String>();
        backward_mapping = new HashMap<String, Character>();
        return isMatch(pattern, str, 0, 0);
    }
}
