/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while(l1 !=null || l2!=null){
            int a = (l1==null) ? 0 : l1.val;
            int b = (l2==null) ? 0 : l2.val;
            int c = (a+b+carry)%10;
            carry = (a+b+carry)/10;
            cur.next = new ListNode(c);
            cur = cur.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if(carry==1) cur.next = new ListNode(carry);
        return dummy.next;
    }
}
