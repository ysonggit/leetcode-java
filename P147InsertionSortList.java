/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        while(cur!=null && cur.next!=null){
            if(cur.val<=cur.next.val){
                cur = cur.next;
            }else{
                ListNode to_insert = cur.next;
                cur.next = cur.next.next;
                ListNode pre = dummy;
                while(pre.next!=null && pre.next.val< to_insert.val){
                    pre = pre.next;
                }
                ListNode post = pre.next;
                to_insert.next = pre.next;
                pre.next = to_insert;
            }
        }
        return dummy.next;
    }
}
