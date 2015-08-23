public class Solution {
    public boolean canPermutePalindrome(String s) {
        int n = s.length();
        if(n<2) return true;
        int freq[] = new int[256];
        for(int i=0; i<n; i++){
            int c_idx = (int) s.charAt(i);
            freq[c_idx]++;
        }
        int count_of_odd_occurances = 0;
        for(int i=0; i<256; i++){
            if(freq[i]%2==1) count_of_odd_occurances++;
        }
        return (count_of_odd_occurances > 1) ? false : true;
    }
}
