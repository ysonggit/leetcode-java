/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode cur = head;
        ListNode pre = null;
        // pre -> cur -> nex
        while(cur != null){
            ListNode nexcp = cur.next;
            cur.next = pre;
            pre = cur; 
            cur = nexcp;
        }
        return pre;
    }
}
