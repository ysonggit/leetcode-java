public class Solution {
    // key: update from right to left
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        int cur_row[] = new int [rowIndex+1];
        int j = 0; 
        while(j< cur_row.length){
            int n = j+1; // row j has n numbers
            cur_row[0] = 1;
            cur_row[n-1] = 1;
            for(int i=n-2; i>0; i--){
                cur_row[i] = cur_row[i-1] + cur_row[i];
            }
            j++;
        }
        for(int i : cur_row){
            row.add(i);
        }
        return row;
    }
}
