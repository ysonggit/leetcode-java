public class Solution {
    /*
        2
      1   3
            5
          4
     2 1 3 5 4 0 
        min   stack
     2  MIN     2
     1  MIN     2 1
     3  2       3
     5  3       5
     4  3       5 4 
     0  
    */
    public boolean verifyPreorder(int[] preorder) {
        if(preorder.length==0) return true;
        int nearest_root = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack<Integer>();
        for(int cur : preorder){
            if(cur < nearest_root) return false;
            while(!path.empty() && cur >path.peek()){
                nearest_root = path.pop();
            }
            path.push(cur);
        }
        return true;
    }
}
