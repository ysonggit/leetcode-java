public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x<10) return true;
        int divider=10;
        while(x/divider>=10){
            divider *=10;
        }
        while(x>0){
            // put if(x<10) return true here is wrong: 100021
            int rightmost=x%10;
            int leftmost=x/divider;
            if(leftmost != rightmost) return false;
            x = x - (leftmost * divider + rightmost);
            x /= 10;  // mistake : donot forget this
            divider /=100;
        }
        return true;
    }
}
