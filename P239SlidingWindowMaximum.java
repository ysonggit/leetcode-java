public class Solution {
    /*
        https://leetcode.com/discuss/46902/my-c-o-n-deque-based-solution-with-explanation
        idea from dong.wang.1694
        So for each i, first pop up the elements that are no larger than nums[i] from buffer 
        until we find one that is larger than nums[i] or the buffer is empty. 
        Then put nums[i] in the buffer. 
        If i>=k-1, we need to ouput the maximum for window [i-k+1, i], 
        which is the front element of buffer. 
        At last, check if the front element is nums[i-k+1], 
        if so, we have to pop it up since it will be out of the window [i-k+2, i+1] in the next iteration.
         
        [1,3,-1,-3,5,3,6,7], and k = 3.
        
        i   buffer    max
        0   1         n/a
        1   3         n/a
        2   3,-1      3
        3   3,-1,-3   3   |also pop 3
            -1,-3  
        4   5         5
        5   5,3       5
        6   6         6
        7   7         7
     
        [1,3,1,2,0,5], 3
        i   window    max
        0   1         n/a
        1   1,3       n/a
        2   3,1       3
        3   3,2       3     
            2
        4   2,0       1
            2,0
        5   5         5
        
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> local_max = new ArrayList<Integer>();
        Deque<Integer> window = new LinkedList<Integer>();
        for(int i=0; i<n; i++){
            while(window.size() > 0 && nums[window.getLast()]<= nums[i]){ 
                window.pollLast(); // mistake: pop from back (very tricky)
            }
            window.offerLast(i);
            if(i>=k-1) local_max.add(nums[window.getFirst()]);
            if(window.getFirst() == i-k+1 ) window.pollFirst();  
        }
        int res [] = new int[local_max.size()];
        for(int i=0; i<local_max.size(); i++){
            res[i] = local_max.get(i);
        }
        return res;
    }
}
