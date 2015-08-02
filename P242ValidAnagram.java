public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()==0) return (t.length() == 0);
        char [] s_chars = s.toCharArray();
        char [] t_chars = t.toCharArray();
        Arrays.sort(s_chars);
        Arrays.sort(t_chars);
        String s_ = new String(s_chars);
        String t_ = new String(t_chars);
        return s_.equals(t_);
    }
}
