/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode dummy_left = new ListNode(-1);
        ListNode dummy_right = new ListNode(-2);
        ListNode left = dummy_left;
        ListNode right = dummy_right;
        ListNode cur = head;
        while(cur != null){
            ListNode next_cp = cur.next;
            if(cur.val < x){
                left.next = cur;
                left = left.next;
                left.next = null;
            }else{
                right.next = cur;
                right = right.next;
                right.next = null;
            }
            cur = next_cp;
        }
        left.next = dummy_right.next;
        return dummy_left.next;
    }
}
