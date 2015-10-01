/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Point pt = points[i];
            int PointMax = 0;
            int SamePoint = 0;
            Map<Double, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                Point neighbor = points[j];
                if (pt.x == neighbor.x && pt.y == neighbor.y) {
                    SamePoint++;
                }else {
                    double s = slope(pt, neighbor);   
                    if (!map.containsKey(s)) {
                        map.put(s, 1);
                    } else {
                        map.put(s, map.get(s) + 1);
                    }
                    PointMax = Math.max(PointMax, map.get(s));
                }
            }
            max = Math.max(max, PointMax + SamePoint + 1);
        }
        return max;
    }
    
    private double slope(Point a, Point b) {
        if (a.x == b.x) {
            return Double.POSITIVE_INFINITY;
        }
        if (a.y == b.y) {
            return 0;
        }
        double s = (double)(a.y - b.y) / (double)(a.x - b.x);
        return s;
    }
}