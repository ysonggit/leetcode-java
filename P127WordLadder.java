public class Solution {
    // save extra space, using stringbuffer to make a new one is too expensive 
    public String replaceWithChar(String s, char c, int i){
        char [] chars = s.toCharArray();
        chars[i] = c;
        return new String(chars);
    }
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(wordDict.size()==0) return 0;
        Queue<String> Q = new LinkedList<String>();
        int len = 1;
        int curr_level = 1, next_level=0;
        Q.offer(beginWord);
        wordDict.remove(beginWord); 
        while(!Q.isEmpty()){
            String cur = Q.poll();
            curr_level--;
            for(int i=0; i<cur.length(); i++){
                char c = cur.charAt(i);
                for(char r = 'a'; r <='z'; r++){
                    if(c != r){
                        String word = replaceWithChar(cur, r, i); 
                        if(word.toString().equals(endWord)) return len+1;
                        if(wordDict.contains(word)){
                            Q.offer(word);
                            wordDict.remove(word);
                            next_level++;
                        }
                    }
                }
            }
            if(curr_level == 0){
                curr_level = next_level;
                next_level = 0;
                len++;
            }
        }
        return 0; // mistake : return 0 not len "hot" "dog" ["hot" "dog"]
    }
}
