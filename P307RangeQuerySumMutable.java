public class NumArray1 {
    // Segment Tree
    class SegmentTreeNode{
        int start, end, sum;
        SegmentTreeNode left, right;
        SegmentTreeNode(int i, int j){
            start = i; end = j; sum = 0;
        }
    }
    SegmentTreeNode build(int[] nums, int i, int j){
        if(i>j) return null;
        SegmentTreeNode root = new SegmentTreeNode(i,j);
        if(i==j){
            root.sum = nums[i];
            return root;
        }
        int mid = i + (j-i)/2;
        root.left = build(nums, i, mid);
        root.right = build(nums, mid+1, j);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    int query(SegmentTreeNode root, int i, int j){
        if(root==null) return -1;
        if(i>j || i>root.end || j<root.start) return -1;
        if(root.start >=i && root.end<=j) return root.sum;
        int mid = root.start + (root.end-root.start)/2;
        if(i>mid) return query(root.right, i, j);
        if(j<=mid) return query(root.left, i, j);
        return query(root.left, i, mid) + query(root.right, mid+1, j);
    }
    void modify(SegmentTreeNode root, int i, int val){
        if(root==null) return;
        if(root.start==i && root.end==i){
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end-root.start)/2;
        if(i<=mid) modify(root.left, i, val);
        else modify(root.right, i, val);
        root.left.sum = query(root.left, root.left.start, root.left.end);
        root.right.sum = query(root.right, root.right.start, root.right.end);
        root.sum = root.left.sum + root.right.sum;
    }
    SegmentTreeNode root;
    public NumArray(int[] nums) {
        root = build(nums, 0, nums.length-1);
    }

    void update(int i, int val) {
        modify(root, i, val);
    }

    public int sumRange(int i, int j) {
        return query(root, i, j);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);

public class NumArray2 {
    // Binary Indexed Tree
    int n;
    int [] tree;
    int [] data;
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int [n+1];
        data = new int [n];
        for(int i=0; i<n; i++){
            update(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int diff = val - data[i]; 
        data[i] = val;
        for(int idx = i+1; idx<=n; idx+=(idx&(-idx))){
            tree[idx] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return sum(j+1) - sum(i);
    }
    
    public int sum(int i){
        int s =0;
        for(int idx=i; idx>0; idx-=(idx&(-idx))){
            s+=tree[idx];
        }
        return s;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
