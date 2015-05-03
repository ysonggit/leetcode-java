/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i=0; i<n; i++){
            fast=fast.next;
        }
        while(fast.next !=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
