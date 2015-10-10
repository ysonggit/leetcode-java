public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        if(m==0) return 0;
        int n = dungeon[0].length;
        int minHP[][] = new int [m+1][n+1];
        Arrays.fill(minHP[m], Integer.MAX_VALUE);
        for(int i=0; i<m; i++){
            minHP[i][n] = Integer.MAX_VALUE;
        }
        minHP[m-1][n] = 1;
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(dungeon[i][j] <=0 || dungeon[i][j]< Math.min(minHP[i+1][j], minHP[i][j+1])){
                    minHP[i][j] = Math.min(minHP[i+1][j], minHP[i][j+1]) - dungeon[i][j];
                }else{
                    minHP[i][j] = 1;
                }
            }
        }
        return minHP[0][0];
    }
}
