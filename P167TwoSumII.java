public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int front =0, back = n-1;
        int [] res = new int[2];
        while(front<back){
            int sum = numbers[front]+numbers[back];
            if(sum==target){
                res[0] = front+1;
                res[1] = back+1;
                return res;
            }else if(sum > target){
                back--;
            }else{
                front++;
            }
        }
        return res;
    }
}
