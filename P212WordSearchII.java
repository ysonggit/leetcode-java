public class Solution {
    class TrieNode{
        boolean is_word;
        HashMap<Character, TrieNode> children;
        TrieNode(){
            is_word = false;
            children = new HashMap<Character, TrieNode>();
        }
    }
    class Trie{
        TrieNode root;
        Trie() { root = new TrieNode(); }
        void insert(String word){
            TrieNode cur = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(!cur.children.containsKey(c)){
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.is_word = true;
        }
    }
    int dx[] ={1,-1,0,0};
    int dy[] ={0,0,1,-1};
    public void dfs(List<String> res, char[][] board, TrieNode cur, String path, int i, int j){
        int m = board.length, n = board[0].length;
        if(i<0||j<0||i>=m || j>=n) return;
        char c = board[i][j];
        if(c=='\0' || !cur.children.containsKey(c)) return;
        String ext_path = path+c;
        if(cur.children.get(c).is_word){
            if(!res.contains(ext_path)) res.add(ext_path);
        }
        board[i][j] = '\0'; // mark visited
        for(int k=0; k<4; k++){
            dfs(res, board, cur.children.get(c), ext_path, i+dx[k], j+dy[k]);
        }
        board[i][j] = c;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(words.length==0 || board.length==0) return res;
        Trie trie = new Trie();
        for(String wd : words) trie.insert(wd);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                dfs(res, board, trie.root, "", i, j);
            }
        }
        return res;
    }
}
