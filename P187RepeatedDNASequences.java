public class Solution {
    // given a 10 letter-long sequence, encode it to an integer (32bit)
    // A->00 
    // C->01
    // G->10
    // T->11
    public int encode(String seq){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        int num = 0;
        for(int i=0; i<seq.length(); i++){
            char c = seq.charAt(i);
            num = num << 2;
            int mask = map.get(c);
            num = num | mask; // mistake : use | not & !
        }
        return num;
    }
    public String decode(int num){
        int mask = 3; // rightmost two bits
        StringBuilder seq = new StringBuilder();
        char letters[] = {'A','C','G','T'};
        for(int i=0; i<10; i++){
            int b = num & mask; // use & 
            num = num>>2;
            seq.insert(0, letters[b]);
        }
        return seq.toString();
    }
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> res = new ArrayList<String>();
        if(n<=10) return res;
        HashMap<Integer, Integer> count= new HashMap<Integer, Integer>();
        for(int i=0; i<n-9; i++){
            String seq = s.substring(i, i+10);
            int num = encode(seq);
            if(count.containsKey(num)){ count.put(num, count.get(num)+1); }
            else count.put(num, 1);
        }
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            if(entry.getValue()>1){
                res.add(decode(entry.getKey()));
            }
        }
        return res;
    }
}
