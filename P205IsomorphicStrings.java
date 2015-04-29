public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int m = s.length(), n = t.length();
        if(m==0 && n==0) return true;
        if(m!=n) return false;
        HashMap<Character, Character> forwardmap = new HashMap<>();
        HashMap<Character, Character> backwardmap = new HashMap<>();
        for(int i=0; i<n; i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(!forwardmap.containsKey(sc)){
                forwardmap.put(sc, tc);
            }else{
                if(forwardmap.get(sc) != tc) return false;
            }
            if(!backwardmap.containsKey(tc)){
                backwardmap.put(tc, sc);
            }else{
                if(backwardmap.get(tc) != sc) return false;
            }
        }
        return true;
    }
}
