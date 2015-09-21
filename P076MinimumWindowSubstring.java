public class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if(m<n) return "";
        int dict_s[] = new int[256];
        int dict_t[] = new int[256];
        char s_arr[] = s.toCharArray();
        char t_arr[] = t.toCharArray();
        for(char c: t_arr) dict_t[(int)c]++;
        int left =0, min_window_start = 0, min_len= m+1, count=0;
        for(int right = 0; right<m; right++){
            int cur = (int)s_arr[right];
            if(dict_t[cur]==0) continue;
            if(dict_t[cur] > dict_s[cur]) count++;
            dict_s[cur]++;
            while(count==n){ // move left
                if(dict_s[(int) s_arr[left]]==0) left++;
                else if(dict_s[(int) s_arr[left]] > dict_t[(int)s_arr[left]]){
                    dict_s[(int) s_arr[left]]--;
                    left++; // order matters!
                }else{
                    if(min_len > right-left+1){
                        min_len = right-left+1;
                        min_window_start = left;
                    }
                    break;// important
                }
            }
        }
        return (min_len>m) ? "" : s.substring(min_window_start, min_window_start+min_len);
    }
}
