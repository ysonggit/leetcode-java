public class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int slow = 0, fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(fast == slow) break;
        }
        fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[fast];
            if(fast==slow) break;
        }
        return slow;
    }
}
