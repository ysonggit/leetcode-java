public class Solution {
    public boolean valid(String num){
        if(num.length()>1 && num.charAt(0)=='0') return false; // 010 is not a valid num
        if(num.length()<=3 && Integer.valueOf(num) < 256) return true;
        return false;
    }
    
    public void dfs(List<String> res, String s, StringBuilder ip, int cur_idx, int seg_count){
        int n = s.length();
        if(cur_idx==n && seg_count == 4){
            res.add(ip.toString());
            return;
        }
        for (int len=1; len <= 3; len++){
            if(cur_idx+len>n) break;
            String num = s.substring(cur_idx, cur_idx+len);
            if(valid(num)){
                int pos_backup = ip.length(); // mistake: must restore this position correctly
                if(ip.length()==0) ip.append(num);
                else ip.append("."+num);
                dfs(res, s, ip, cur_idx+len, seg_count+1);
                ip.delete(pos_backup, ip.length()); // mistake: not starting from cur_idx since extra dots were added 
            }
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int n = s.length();
        if(n==0||n>12) return res;
        StringBuilder ip = new StringBuilder();
        dfs(res, s, ip, 0, 0);
        return res;
    }
}
