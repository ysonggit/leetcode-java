public class Solution {
    public String intToRoman(int num) {
        int numeric [] ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String letters [] ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        while(num>0){
            for(int i=0; i<numeric.length; i++){
                if(num>= numeric[i]){
                    roman.append(letters[i]);
                    num -= numeric[i];
                    break;
                }
            }
        }
        return roman.toString();
    }
}
