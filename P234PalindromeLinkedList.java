/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // d 1 2 3 4
    // idea: first reverse the second half of the linked list 
    // then compare the first half with the reversed second half
    // pre -> cur -> nex
    public ListNode reverse(ListNode head){
        if(head==null) return null;
        if(head.next ==null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode nex = null;
        while(cur != null){
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        if(head.next == null) return true;
        ListNode dummy = new ListNode (-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode rev_second = reverse(second);
        ListNode first = head;
        while(first != null && rev_second != null){
            if(first.val != rev_second.val) return false;
            first = first.next;
            rev_second = rev_second.next;
        }
        return true;
    }
}
