public class WordDictionary {
    class TrieNode{
        boolean isword;
        HashMap<Character, TrieNode> children;
        TrieNode(){
            isword = false;
            children = new HashMap<Character, TrieNode>();
        }
    }
    
    TrieNode root;
    WordDictionary(){
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word==null || word.length()==0) return;
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isword = true;
    }

    public boolean search(TrieNode node, String word){
        if(word==null || word.length()==0) { 
            // Most tricky part !!!
            if(node == null) return true;
            if(node.isword) return true;
            if(node.children.size()>0) return false;
        }
        TrieNode cur = node;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(c != '.') {
                if(!cur.children.containsKey(c)) return false;
                cur = cur.children.get(c);
            }else{
                for(Map.Entry<Character, TrieNode> entry : cur.children.entrySet()){
                    TrieNode n = entry.getValue();
                    String w = word.substring(i+1);
                    if(search(n, w)==true) return true;
                }
                return false;
            }
        }
        return cur.isword;
    }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root, word);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
