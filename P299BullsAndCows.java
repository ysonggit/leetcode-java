public class Solution {
    public String getHint(String secret, String guess) {
        int bulls =0, cows =0;
        int count[] = new int [10];
        for(int i=0; i<secret.length(); i++){
            int s = (int)(secret.charAt(i)-'0'), g = (int)(guess.charAt(i)-'0');
            if(s==g) bulls++;
            else{
                if(count[s]>0) cows++;
                if(count[g]<0) cows++;
                count[s]--;
                count[g]++;
            }
        }
        return bulls+"A"+cows+"B";
    }
}
