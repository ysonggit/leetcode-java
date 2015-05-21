public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if(n<2) return;
        int i=0;
        int r = -1, b = n;
        while(i<b){
            if(nums[i]==0){ // red found
                r++;
                nums[i] = nums[r];
                nums[r]= 0;
                i++;
            }else if(nums[i]==2){ // blue found
                b--;
                nums[i] = nums[b];
                nums[b] = 2;
            }else{
                i++;
            }
        }
        
    }
}
