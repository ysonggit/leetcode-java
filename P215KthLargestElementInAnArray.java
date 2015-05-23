public class Solution {
    // idea : max heap
    class MaxHeapCmp implements Comparator<Integer>{
        public int compare (Integer a, Integer b){
            return b - a;
        }
    }
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        //if(k>n || k<1) return -1;
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(n, new MaxHeapCmp());
        for(int i:nums){
            // insert to the priority queue
            maxheap.offer(i);
        }
        for(int j=0; j<k-1; j++){
            maxheap.poll();
        }
        return maxheap.peek();
    }
}
