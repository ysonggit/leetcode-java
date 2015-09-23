/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution1 {
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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    // 1->2
    public ListNode reverseList(ListNode head) {
        if(head == null|| head.next == null) return head;
        ListNode second = head.next;
        head.next = null;
        ListNode rev_rest = reverseList(second);
        second.next = head;
        return rev_rest;
    }
}
