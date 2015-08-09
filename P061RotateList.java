/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null ) return null;
        if(head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        int n = 0;
        while(cur.next!= null){
            cur = cur.next;
            n++;
        }
        cur.next = dummy.next;
        if(k>n) k = k % n;
        // from cur, move n - k steps forward and then break the cyclic list
        for(int i=0; i<(n-k); i++){
            cur = cur.next;
        }
        ListNode newhead = cur.next;
        cur.next = null;
        return newhead;
    }
}
