/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode split(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        return right;
    }
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(left!=null && right!=null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if(left!=null) cur.next = left;
        if(right!=null) cur.next = right;
        return dummy.next;
    }
    
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode right = split(head);
        ListNode left = head;
        return merge(sortList(left), sortList(right));
    }
}
