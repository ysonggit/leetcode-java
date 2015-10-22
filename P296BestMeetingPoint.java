public class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid.length==0) return 0;
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        Collections.sort(x);
        Collections.sort(y);
        int median_x = (x.size()%2==1) ? x.size()/2 : x.size()/2-1;
        int median_y = (y.size()%2==1) ? y.size()/2 : y.size()/2-1;
        int pos_x = x.get(median_x), pos_y = y.get(median_y);
        int total_dist = 0;
        for(int i = 0; i< x.size(); i++){
            total_dist += Math.abs(x.get(i)-pos_x) + Math.abs(y.get(i)-pos_y);
        }
        return total_dist;
    }
}
