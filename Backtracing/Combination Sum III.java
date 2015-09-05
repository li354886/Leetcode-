public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(result, path, k, n, 1);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> path, int k, int n, int start) {
        if (k < 0 || n < 0) {
            return;
        } else if (k == 0 && n == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(result, path, k - 1, n - i, i + 1);
            path.remove(path.size() - 1);
        }
    }
}}