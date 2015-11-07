public class Solution {
    // DFS TLE
    class Pos{
        int x, y;
        Pos(int i, int j) {
            x = i; y = j;
        }
    }
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        if(m==0) return 0;
        int n = image[0].length;
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        Queue<Pos> Q = new LinkedList<Pos>();
        boolean [][] visited = new boolean[m][n];
        visited[x][y] = true;
        Q.offer(new Pos(x, y));
        int min_x = x, max_x = x, min_y= y, max_y = y;
        while(!Q.isEmpty()){
            int num = Q.size();
            for(int z=0; z<num; z++){
                Pos cur = Q.poll();
                for(int k=0; k<4; k++){
                    Pos nb = new Pos(cur.x+dx[k], cur.y+dy[k]);
                    if(nb.x<0||nb.y<0||nb.x==m||nb.y==n) continue;
                    if(visited[nb.x][nb.y]|| image[nb.x][nb.y]=='0') continue;
                    visited[nb.x][nb.y]= true;
                    Q.offer(nb);
                    min_x = Math.min(min_x, nb.x);
                    min_y = Math.min(min_y, nb.y);
                    max_x = Math.max(max_x, nb.x);
                    max_y = Math.max(max_y, nb.y);
                }
            }
        }
        return (max_x-min_x+1)*(max_y-min_y+1);
    }
}
