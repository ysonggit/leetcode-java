public class Solution {
    public void appendSpaces(List<String> res, int num_spaces, String next_word){
        int last_idx = res.size()-1;
        StringBuilder last_wd = new StringBuilder(res.get(last_idx));
        for(int i=0; i<num_spaces; i++) last_wd.append(' ');
        last_wd.append(next_word);
        res.set(last_idx, last_wd.toString());
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int cur = 0, n = words.length;
        while(cur<n){
            int start = cur;
            int cur_line_width = words[cur++].length();
            while(cur<n && cur_line_width+1+words[cur].length()<=maxWidth){
                cur_line_width += 1+words[cur++].length();
            }
            int spaces = 1, extra = 0;
            int num_words = cur - start;
            if(cur<n && num_words > 1){ // not the only word in line
                spaces = (maxWidth-cur_line_width)/(num_words-1)+1;
                extra = (maxWidth-cur_line_width)%(num_words-1);
            }
            res.add(words[start++]);
            while(extra >0){ 
                appendSpaces(res, spaces+1, words[start++]);
                extra--;
            }
            while(start < cur){
                appendSpaces(res, spaces, words[start++]);
            }
            int justified_line_width = res.get(res.size()-1).length();
            appendSpaces(res, maxWidth- justified_line_width, "");
        }
        return res;
    }
}
