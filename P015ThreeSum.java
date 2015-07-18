public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res  = new ArrayList<List<Integer>>();
        if(n<3) return res;
        Arrays.sort(nums);
        int i = 0;
        while(i<n){
            int target = -nums[i];
            // two sums 
            int front = i+1, back = n-1;
            while(front<back){
                int two_sum = nums[front] + nums[back];
                if(two_sum == target){
                    List<Integer> sol = Arrays.asList(new Integer(-target), new Integer(nums[front]), new Integer(nums[back]));
                    res.add(sol);
                    front++;
                    back--;
                    while(front<back && nums[front] == nums[front-1]) front++; // bug: must have front<back, otherwise out range
                    while(front<back && nums[back]== nums[back+1]) back--;
                }else if(two_sum < target){
                    front++;
                }else{
                    back--;
                }
            }
            while(i+1<n && nums[i]== nums[i+1]) i++;
            i++; // putting i++ before while() can't avoid duplicates
        }
        return res;
    }
}
