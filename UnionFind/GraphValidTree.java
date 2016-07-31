public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int root1 = find(root, edges[i][0]);
            int root2 = find(root, edges[i][1]);
            if (root1 == root2) {
                return false;
            }
            root[root1] = root2;
        }
        return edges.length == n - 1;
    }
    
    private int find(int[] root, int e) {
        if (root[e] == e) {
            return e;
        }
        return find(root, root[e]);
    }
}