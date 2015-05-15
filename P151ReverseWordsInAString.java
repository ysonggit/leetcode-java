public class Solution {
    public String reverseWords(String s) {
        StringBuilder rev = new StringBuilder();
        s=s.trim();
        if(s.length()==0) return "";
        int i = s.length()-1;
        while(i>=0){
            while(i>=0 && s.charAt(i)==' ') i--;
            if(i<0) break;
            StringBuilder word = new StringBuilder();
            while(i>=0 && s.charAt(i) != ' '){ // mistake : do not forget to check i>=0
                word.append(s.charAt(i));
                i--;
            }
            if(rev.length()==0){
                rev.append(word.reverse().toString());  
            } 
            else{
                // append a space before appending another word
                rev.append(" "+word.reverse().toString());
            }
        }
        return rev.toString();
    }
}
