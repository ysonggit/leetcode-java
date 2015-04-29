/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int getLength(ListNode head){
        if(head==null) return 0;
        return getLength(head.next)+1;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = getLength(headA);
        int n = getLength(headB);
        if(m==0 || n==0) return null;
        ListNode a = headA;
        ListNode b = headB;
        if(m>n){
            for(int i=0; i<m-n; i++){
                a = a.next;
            }
        }
        if(m<n){
            for(int i=0; i<n-m; i++){
                b = b.next;
            }
        }
        // now two lists are aligned
        while(a !=null && b != null){
            if(a==b) return a;
            a = a.next; 
            b = b.next;
        }
        return null;
    }
}
