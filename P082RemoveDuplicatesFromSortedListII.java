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
        if(head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        boolean dup_found = false;
        while(cur != null && cur.next != null){
            while(cur.val == cur.next.val){ // mistake: forgot to check if cur.next is null
                cur = cur.next;
                dup_found = true;
                if(cur.next ==null) break; 
            }
            if(dup_found){
                pre.next = cur.next;
                cur = pre.next;
                dup_found = false;   
            }else{
                pre = cur;
                cur = cur.next;
            }
            
        }
        return dummy.next;
    }
}
