public class Solution {
    /**
     * 1. sign;
     * 2. overflow handle (long long) numerator = INT_MIN, denominator = -1
     * 3. numerator/denominator 0
     */ 
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        if(denominator==0) return "NaN";
        String sign = ((numerator ^ denominator) >= 0) ? "" : "-";
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        String int_part = String.valueOf(n/d);
        boolean has_frac = (n%d == 0) ? false : true;
        StringBuilder frac = new StringBuilder("");
        if(has_frac){
            frac.append(".");
            long rem = n % d;
            // rem_pos[i] = j means frac has length of j when the last remainder was i
            HashMap<Long, Integer> rem_pos = new HashMap<Long, Integer>();
            while(rem != 0){
                if(rem_pos.containsKey(rem)){
                    // recur found, use () to wrap the segments
                    // starting from last occurance of this remainder to the end of frac
                    int recur_start = rem_pos.get(rem);
                    String non_recur = frac.substring(0, recur_start);
                    String recur = frac.substring(recur_start);
                    return sign+int_part+non_recur+"("+recur+")";
                }
                rem_pos.put(rem, frac.length());
                frac.append(String.valueOf(rem*10/d)); // mistake : not rem!
                rem = (rem * 10) % d;
            }
        }
        return sign + int_part + frac.toString();
    }
}
