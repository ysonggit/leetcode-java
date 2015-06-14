public class Solution {
    public void reverse(char [] s, int front, int back){
        while(front<back){
            char tmp = s[back];
            s[back] = s[front];
            s[front] = tmp;
            front++;
            back--;
        }
    }
    public void reverseWords(char[] s) {
        int n = s.length;
        if(n<2) return;
        int front = 0, back = n-1;
        // reverse entire array
        reverse(s, front, back);
        // reverse each word 
        int start =0, end=0;
        while(end<n){
            if(s[end]!=' ' && s[start]!=' '){ 
                end++;
            }
            if(end==n || s[end]==' '){ // mistake: end==n not n-1
                front = start;
                back = end-1;
                reverse(s, front, back);
                end++;
                start=end;
            }
        }
    }
}
