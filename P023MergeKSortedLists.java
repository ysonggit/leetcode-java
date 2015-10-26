/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // idea k size minheap, O(nklogk) n is size of a list
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k==0) return null;
        Queue<ListNode> minheap = new PriorityQueue<ListNode>((a,b) -> (a.val-b.val));
        for(int i=0; i<k; i++){
            if(lists[i]==null) continue;
            minheap.offer(lists[i]);
            lists[i] = lists[i].next;
        }
        ListNode substitute = null;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(!minheap.isEmpty()){
            substitute = minheap.peek().next;
            cur.next = minheap.poll();
            cur = cur.next;
            if(substitute!=null) minheap.offer(substitute);
        }
        return dummy.next;
    }
}
