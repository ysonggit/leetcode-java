/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur!=null && cur.next!= null){
            while(cur.next.val==val){
                cur.next = cur.next.next;
                if(cur.next== null) break;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
