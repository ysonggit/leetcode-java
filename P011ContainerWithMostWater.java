public class Solution {
    // two pointers
    public int maxArea(int[] height) {
        int n = height.length;
        if(n<2) return 0;
        int front =0, back=n-1;
        int max_volume = 0;
        while(front<back){
            int left = height[front], right = height[back];
            int vol = Math.min(left, right) * (back-front);
            max_volume = Math.max(max_volume, vol);
            if(left < right){
                front++;
            }else{
                back--;
            }
        }
        return max_volume;
    }
}
