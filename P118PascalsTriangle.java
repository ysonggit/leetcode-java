public class Solution {
    public List<Integer> generateNextRow(List<Integer> cur_row){
        int next_row[] = new int [cur_row.size()+1]; // fuck, fail to new an arraylist?!
      	int n = next_row.length;
      	next_row[0]=1;
        next_row[n-1]=1;
        for(int i=1; i<n-1; i++){
            next_row[i]= cur_row.get(i-1)+cur_row.get(i);
        }
		List<Integer> next = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
       	    next.add(next_row[i]); 
        }
        return next;
    }
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal_triangle = new ArrayList<List<Integer>>();
        if(numRows==0) return pascal_triangle;
        List<Integer> cur_row = new ArrayList<Integer>();
        for(int i=0; i<numRows; i++){
            List<Integer> next_row = generateNextRow(cur_row);
            pascal_triangle.add(next_row);
            cur_row = next_row;
        }
        return pascal_triangle;
    }
}
