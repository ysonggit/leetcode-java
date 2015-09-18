public class Solution {
    // from zxyperfect
    public String getPermutation(int n, int k) {
        int permu_table[] = new int[10]; 
        // 1 1 2 6 24 120 720 5040 40320 362880
        permu_table[0] = 1;
        List<Integer> digits = new ArrayList<Integer>();
        // 1 2 3 4 5 6 7 8 9
        for(int i=1; i<=9; i++){
            permu_table[i] = i* permu_table[i-1];
            digits.add(i); 
        }
        char permu[] = new char[n];
        for(int i=n; i>0; i--){
            int j=((k-1)%permu_table[i])/permu_table[i-1];
            permu[n-i] = (char)((int)'0'+digits.get(j));
            // donot forget to remove j-th digit
            digits.remove(digits.get(j));
        }
        return new String(permu);
    }
}
