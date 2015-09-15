public class Vector2D {
    int x, y;
    List<List<Integer>> mat;
    public Vector2D(List<List<Integer>> vec2d) {
        mat = vec2d;
        x = 0;
        y = 0;
    }

    public int next() {
        return mat.get(x).get(y++);
    }

    public boolean hasNext() {
       if(mat.size()==0) return false;
       while(x<mat.size() && y>=mat.get(x).size()) {
           x++;
           y = 0;
       }
       return (x<mat.size()) ? true : false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
