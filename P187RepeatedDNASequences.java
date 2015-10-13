public class Solution {
    // use an integer to encode a 10-character string:
    // A: 00 | C: 01 | G: 10 | T: 11
    HashMap<Character, Integer> table = new HashMap<Character, Integer>();
    public int encode(String seq){
        int key = 0;
        for(int i=0; i<seq.length(); i++){
            int mask= table.get(seq.charAt(i));
            key |= mask;
            key <<= 2;
        }
        return key;
    }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        int n = s.length();
        if(n<10) return res;
        table.put('A', 0);
        table.put('C', 1);
        table.put('G', 2);
        table.put('T', 3);
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for(int i=0; i<=n-10; i++){
            String seq = s.substring(i, i+10);
            //int key = seq.hashCode(); 
            //mistake: different strings produce duplicated keys 
            //if using C++ hash<string>, works well 
            int key = encode(seq);
            if(!counts.containsKey(key)){
                counts.put(key, 1);
            }else{
                counts.put(key, counts.get(key)+1);
                if(counts.get(key)==2){
                    res.add(seq);
                } 
            }
        }
        return res;
    }
}
