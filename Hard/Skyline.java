public class Solution {
    class EdgePoint {
        int height;
        boolean isStart;    // start point or end point
    
        public EdgePoint(int height, boolean isStart) {
            this.height = height;
            this.isStart = isStart;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> skyline = new ArrayList<int[]>();
        int n = buildings.length;
        if (n == 0) {
            return skyline;
        }
        Map<Integer, List<EdgePoint>> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int left = buildings[i][0];
            int right = buildings[i][1];
            int height = buildings[i][2];
            if (!map.containsKey(left)) {
                map.put(left, new ArrayList<EdgePoint>());               
                pq.add(left);
            }
            map.get(left).add(new EdgePoint(height, true));
            if (!map.containsKey(right)) {
                map.put(right, new ArrayList<EdgePoint>());
                pq.add(right);
            }
            map.get(right).add(new EdgePoint(height, false));
        }
        
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        int prevHeight = 0;
        int currHeight = 0;
        while (!pq.isEmpty()) {
            int x = pq.poll();
            currHeight = 0;
            for (EdgePoint pt : map.get(x)) {
                int height = pt.height;
                if (pt.isStart) {
                    if (!tree.containsKey(height)) {
                        tree.put(height, 1);
                    }else {
                        tree.put(height, tree.get(height) + 1);
                    }
                } else {
                    if (tree.get(height) == 1) {
                        tree.remove(height);
                    } else {
                        tree.put(height, tree.get(height) - 1);
                    }
                }
            }
            currHeight = tree.isEmpty() ? 0 : tree.lastKey();
            if (currHeight != prevHeight) {
                skyline.add(new int[]{x, currHeight});
                prevHeight = currHeight;
            }
        }
        return skyline;
    }
}