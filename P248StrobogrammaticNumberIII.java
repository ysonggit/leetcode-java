public class Solution {
    // D[i] : number of strobogrammatic numbers of i-digit
    // D[0] = 0  {""} 
    // D[1] = 3  {0,1,8}
    // D[2] = 4  {11,69,88,96}
    // D[3] = 12 {101 111 181 609 619 689 808 818 888 906 916 986}
    // D[i] = D[i-1] * D[1] if i is odd
    //      = D[i-2] * (D[2] +1) if i is even (+1 because of inserting a "00")
    public boolean less_than(String a, String b){
        int m = a.length(), n = b.length();
        if(m<n) return true;
        if(m==n){
            for(int i=0; i<m; i++){
                if(a.charAt(i) > b.charAt(i)) return false;
                else if(a.charAt(i)== b.charAt(i)) continue;
                else return true;
            }
        }
        return false;
    }
    public List<String> trickyRecur(int n, int final_n){
        if(n==0) return Arrays.asList("");
        if(n==1) return Arrays.asList("0","1","8");
        List<String> res = new ArrayList<String>();
        for(String num : trickyRecur(n-2, final_n)){
            if(final_n !=n) res.add("0"+num+"0");
            res.add("1"+num+"1");
            res.add("6"+num+"9");
            res.add("8"+num+"8");
            res.add("9"+num+"6");
        }
        Collections.sort(res);
        return res;
    }
    public int strobogrammaticInRange(String low, String high) {
        if(less_than(high, low)) return 0;
        int m = low.length(), n = high.length();
        int count = 0;
        int D[] = new int[n+1];       
        D[0] = 0;
        D[1] = 3;
        if(n>1) D[2] = 4;
        for(int i=3; i<=n; i++){
            if(i%2==1){
                D[i] = D[i-1] * D[1];
            }else{
                D[i] = D[i-2] * (D[2]+1);
            }
        }
        if(n-m>1){
            // m+1/m+2/ .. /n-1  digits numbers 
            for(int i=m+1; i<=n-1; i++){
                count += D[i]; 
            }
        }
        // reuse strobogrammatic number II
        // count the m-digit and n-digit numbers in range 
        List<String> m_digit_strobo = trickyRecur(m, m);
        List<String> n_digit_strobo = trickyRecur(n, n);
        for(int i=0; i<m_digit_strobo.size(); i++){
            String num = m_digit_strobo.get(i);
            if(less_than(low, num) || num.equals(low)) {
                if(less_than(num, high) || num.equals(high))   
                    count++;
            }
        }
        if(m==n) return count; // 101 181
        for(int i=0; i<n_digit_strobo.size(); i++){
            String num = n_digit_strobo.get(i);
            if(less_than(num, high) || num.equals(high)) count++;
            else break;
        }
        return count;
    }
}
