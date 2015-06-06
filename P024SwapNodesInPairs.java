/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // pre -> cur -> nex ->
    public void swapNodes(ListNode pre, ListNode cur, ListNode nex){
        cur.next = nex.next;
        nex.next = cur;
        pre.next = nex;
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(pre!=null && cur != null && cur.next != null){
            ListNode nexnex = cur.next.next;
            swapNodes(pre, cur, cur.next);
            pre = cur;
            cur = nexnex;
        }
        return dummy.next;
    }
}
