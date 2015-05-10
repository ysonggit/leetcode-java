public class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        if(n==0) return 0;
        char letter[] = {'I', 'V', 'X', 'L','C', 'D', 'M'};
        int digit[] = {1, 5, 10, 50,100,500,1000};
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for(int j=0; j<digit.length; j++){
            dict.put(letter[j], digit[j]);
        }
        int i=0;
        int num = 0;
        while(i<n){
            char cur = s.charAt(i);
            if(i>0 &&  dict.get(cur)  > dict.get(s.charAt(i-1))){
                num += dict.get(cur) - 2 * dict.get(s.charAt(i-1));
            }else{
                num += dict.get(cur);
            }
            i++;
        }
        return num;
    }
}
