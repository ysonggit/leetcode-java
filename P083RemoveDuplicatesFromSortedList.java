/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null){
            while(cur.next.val==cur.next.next.val){
                cur.next = cur.next.next;
                if(cur.next.next == null) break;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
