/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverse(ListNode head){
        if(head==null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nexcp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nexcp;
        }
        return pre;
    }
    // 1->2->3->4
    public void reorderList(ListNode head) {
        if(head==null) return;
        if(head.next == null) return;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null && fast.next != null){
            fast= fast.next.next;
            slow = slow.next;
        }
        // reverse righthalf, fast is the head node of the right half
        ListNode right = reverse(slow.next);
        slow.next = null;
        ListNode cur = dummy;
        ListNode left = dummy.next;
        boolean insert_right = false;
        while(right != null){
            if(insert_right){
                cur.next = right;
                right = right.next;
                insert_right = false;
            }else{
                cur.next = left;
                left = left.next;
                insert_right = true;
            }
            cur = cur.next;
        }
        if(left !=null) cur.next = left;
    }
}
