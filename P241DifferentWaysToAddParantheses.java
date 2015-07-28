public class Solution {
    /*
        similar to unique binary search trees 
        divide and conquer
        divide once meets an operator
        2*3-4*5
    */
    public List<Integer> diffWaysToCompute(String input) {
       int n = input.length();
       List<Integer> res = new ArrayList<Integer>();
       if(n==0) return res;
       for(int i=0; i<n; i++){
           char c = input.charAt(i);
           if(c=='+' || c=='-' || c=='*'){
               String left = input.substring(0, i);
               String right = input.substring(i+1);
               List<Integer> left_res = diffWaysToCompute(left);
               List<Integer> right_res = diffWaysToCompute(right);
               for(Integer lh : left_res){
                   for(Integer rh : right_res){
                       Integer ans = 0;
                       if(c=='+'){
                           ans = lh + rh;
                       }else if(c=='-'){
                           ans = lh - rh;
                       }else{
                           ans = lh * rh;
                       }
                       res.add(ans);
                   }
               }
           }
       }
       // base case : only number  
       // if res is empty, means no operator found in the input string
       if(res.size() == 0) res.add(Integer.valueOf(input)); 
       return res;
    }
}
