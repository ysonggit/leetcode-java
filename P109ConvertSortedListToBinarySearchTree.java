public int getListLength(ListNode head){
    if(head==null) return 0;
    return 1+getListLength(head.next);
}

public ListNode curhead; // important! 

public TreeNode build(int len){
    if(curhead==null || len<=0) return null;
    TreeNode left = build(len/2);
    TreeNode root = new TreeNode(curhead.val);
    root.left = left;
    curhead = curhead.next;
    TreeNode right = build(len-len/2-1);
    root.right = right;
    return root;
}

public TreeNode sortedListToBST(ListNode head) {
    int len = getListLength(head);
    curhead = head; 
    return build(len);
}   
