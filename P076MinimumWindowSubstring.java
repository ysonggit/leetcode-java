class Solution {
    public String minWindow(String s, String t) {
        int [] need = new int[128];
        int count = 0;
        for(char c : t.toCharArray()) need[(int) c] ++;
        int begin = 0, minLen = Integer.MAX_VALUE, head = 0;
        for(int end = 0; end<s.length(); end++){
            char c = s.charAt(end);
            need[(int)c]--;
            if(need[(int)c]>=0) count++; 
            while(count == t.length()){ // find one substring
                if(end-begin+1<minLen) {
                    minLen = end - begin + 1;
                    head = begin;
                }
                char h = s.charAt(begin);
                need[(int)h] ++;
                if(need[(int)h]>0) count--;
                begin++;
            }
        }
        return minLen > s.length() ? "" : s.substring(head, minLen+head);
    }
}
