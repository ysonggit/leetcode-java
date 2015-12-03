public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> visited = new HashSet<String>();
        Queue<String> Q = new LinkedList<String>();
        Q.offer(beginWord);
        visited.add(beginWord);
        int len=1;
        while(!Q.isEmpty()){
            int num= Q.size();
            for(int k=0; k<num; k++){
                String cur = Q.poll();
                char[] wd = cur.toCharArray();
                for(int i=0; i<wd.length; i++){
                    char orig = wd[i];
                    for(char c = 'a'; c<='z'; c++){
                        if(orig == c) continue;
                        wd[i] = c;
                        String nex = new String(wd);
                        if(nex.equals(endWord)) return len+1;
                        if(wordList.contains(nex) && !visited.contains(nex)){
                            visited.add(nex);
                            Q.offer(nex);
                        }
                    }
                    wd[i] = orig;
                }
            }
            len++;
        }
        return 0; // mistake: return len is wrong
    }
}
