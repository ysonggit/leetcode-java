public class Solution {
    public ArrayList<String> getOneEditWords(String word){
        ArrayList<String> neighbors = new ArrayList<String>();
        char wd[] = word.toCharArray();
        for(int i=0; i<wd.length; i++){
            char origin = wd[i];
            for(char c = 'a'; c<='z'; c++){
                if(wd[i] != c) { 
                    wd[i] = c;
                    neighbors.add(new String(wd));
                    wd[i] = origin;
                }
            }
        }
        return neighbors;
    }
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(wordDict.size()==0) return 0;
        Queue<String> Q = new LinkedList<String>();
        Q.offer(beginWord);
        HashSet<String> visited = new HashSet<String>();
        visited.add(beginWord);
        int len = 1;
        int curr_level = 1, next_level=0;
        while(!Q.isEmpty()){
            String cur = Q.poll();
            curr_level--;
            for(String next : getOneEditWords(cur)){
                if(next.equals(endWord)){ return len+1;}
                if(wordDict.contains(next)) {
                    if(!visited.contains(next)){
                        Q.offer(next);
                        visited.add(next);
                        next_level++;
                    }
                }
            }
            if(curr_level==0){
                curr_level = next_level;
                next_level = 0;
                len++;
            }
        }
        return 0;
    }
}
