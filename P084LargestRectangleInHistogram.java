public class Solution {
    public int largestRectangleArea(int[] height) {
        int n = height.length;
        if(n==0) return 0;
        int max_area = 0;
        Stack<Integer> highest_bars_left = new Stack<Integer>();
        int H[] = Arrays.copyOf(height, n+1);
        // make sure the stack will be popped empty
        for(int i=0; i<=n; i++){
            while(!highest_bars_left.empty() &&
                    H[i] < H[highest_bars_left.peek()]){
                int highest_idx = highest_bars_left.pop();
                int width = highest_bars_left.empty() ? i : (i-1-highest_bars_left.peek());
                max_area = Math.max(max_area, width * H[highest_idx]);
            }
            highest_bars_left.push(i);
        }
        return max_area;
    }
}
