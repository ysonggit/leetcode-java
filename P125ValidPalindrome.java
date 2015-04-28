public class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if(n<=1) return true;
        int front = 0; 
        int back = n-1;
        char str[] = s.toLowerCase().toCharArray();
        while(front<back){
            while(front<back && !Character.isLetterOrDigit(str[front])) front++;
            while(front<back && !Character.isLetterOrDigit(str[back])) back--;
            if(front<back && str[front] != str[back]) return false;
            front++;
            back--;
        }
        return true;
    }
}
