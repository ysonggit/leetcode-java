public class Solution {
    // at most 2 majority numbers
    // corner case [2,2]
    class Candidate{
        int val;
        int count;
        Candidate(){
            val = 0;
            count = 0;
        }
    }
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int n = nums.length;
        if(n==0) return res;
        Candidate c1 = new Candidate();
        Candidate c2 = new Candidate();
        for(int i : nums){
            if(i==c1.val && c1.count>0){
                c1.count++;
            }else if(i==c2.val && c2.count > 0){
                c2.count++;
            }else{
                if(c1.count==0){
                    c1.val = i;
                    c1.count = 1;
                }else if (c2.count == 0){
                    c2.val = i;
                    c2.count = 1;
                }else{
                    c1.count--;
                    c2.count--;
                }
            }
        }
        // recheck two candiates, make sure they are indeed majority number(s)
        int count1 = 0, count2 = 0;
        for(int i : nums){
            if(i==c1.val && c1.count>0) count1++;
            if(i==c2.val && c2.count>0) count2++;
        }
        if(count1> (n/3)) res.add(c1.val);
        if(count2> (n/3)) res.add(c2.val);
        return res;
    }
}
