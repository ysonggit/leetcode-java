/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i=0; i<m-1; i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        // reverse from m-th node to n-th node (totally n-m times)
        // pre -> | cur -> node_move_to_front -> ... | ->
        //             becomes     
        // pre -> | node_move_to_front -> cur -> ... | ->
        for(int j=0; j<n-m; j++){
            ListNode node_move_to_front = cur.next;
            cur.next = node_move_to_front.next;
            node_move_to_front.next = pre.next; // mistake: should update pre.next every iteration
            pre.next = node_move_to_front;
        }
        return dummy.next;
    }
}
