public class Solution1 {
    class Point{
        int x, y;
        Point(int i, int j){ x = i; y = j; }
    }
    class Rectangle {
        Point ll, ur;
        Rectangle(Point a, Point b){ 
            ll = new Point(a.x, a.y);
            ur = new Point(b.x, b.y);
        }
        int area(){ 
            return (ur.x-ll.x) * (ur.y-ll.y);
        }
    }
    // assume inputs are valid
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        Point ll1 = new Point(A,B);
        Point ur1 = new Point(C,D);
        Point ll2 = new Point(E,F);
        Point ur2 = new Point(G,H);
        Rectangle r1 = new Rectangle(ll1, ur1);
        Rectangle r2 = new Rectangle(ll2, ur2);
        Point ll = new Point(Math.max(ll1.x, ll2.x), Math.max(ll1.y, ll2.y));
        Point ur = new Point(Math.min(ur1.x, ur2.x), Math.min(ur1.y, ur2.y));
        Rectangle intersection = new Rectangle(ll, ur);
        return r1.area()+r2.area() - intersection.area();
    }
}

public class Solution2 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = Math.abs(C-A) * Math.abs(D-B);
        int area2 = Math.abs(G-E) * Math.abs(H-F);
        if(B>=H || C<=E || F>=D || G<=A) return area1+area2;
        int width = Math.abs(Math.min(C,G)-Math.max(E,A));
        int height = Math.abs(Math.min(H,D)-Math.max(B,F));
        return area1+area2-width*height;
    }
}
