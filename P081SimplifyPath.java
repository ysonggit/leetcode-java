public class Solution {
    public String simplifyPath(String path) {
        if(path.length()==0) return "";
        String dirs [] = path.split("/");
        Stack<String> ps = new Stack<String>();
        for(String s: dirs){
            if(s.equals(".") ||s.equals("")) continue;
            if(s.equals("..")){
                if(!ps.empty()) ps.pop(); // mistake: if ps.empty, should continue until no more string in array
            }else{
                ps.push(s);
            }
        }
        if(ps.empty()) return "/";
        StringBuilder res = new StringBuilder();
        while(!ps.empty()){
            res.insert(0, ps.pop());
            res.insert(0, "/");
        }
        return res.toString();
    }
}
