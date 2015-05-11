/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode build(int[] nums, int low, int high){
        if(low>high) return null;
        int mid = (low+high)/2;
        int val = nums[mid];
        TreeNode root = new TreeNode(val);
        root.left = build(nums, low, mid-1);
        root.right = build(nums, mid+1, high);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if(n==0) return null;
        return build(nums, 0, n-1);
    }
}
