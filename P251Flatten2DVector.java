public class Vector2D {
    int x, y;
    List<List<Integer>> mat;
    public Vector2D(List<List<Integer>> vec2d) {
        mat = vec2d;
        x = 0;
        y = 0;
    }

    public int next() {
        int val = mat.get(x).get(y);
        y++;
        //System.out.println("Mat("+x+","+y+"):"+val);
        if(y>= mat.get(x).size()){
            x++;
            y=0;
        }
        return val;
    }

    public boolean hasNext() {
       if(mat.size()==0) return false;
       if(x>=mat.size()) return false; // must check before while
       while(mat.get(x).size()==0) {   // must have a while loop to filter first several empty rows
            x++;
            if(x>= mat.size() ) return false;
       }
       if(y>= mat.get(x).size()) return false;
       return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
