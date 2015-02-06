public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        if (n == 0 || k == 0) {
           return ret;    
        }
        
        List<Integer> path = new ArrayList<Integer>();
        
        combine(n, k, path, ret, 1); //Here is 1 because index is not the cursor anymore, is the specific number
        
        return ret;
    }
    
    public void combine(int n, int k, List<Integer> path, List<List<Integer>> ret, int index) {
        if (k == 0) {
            ret.add(new ArrayList<Integer> (path));
            return;
        }
        
        for (int i = index; i<= n-k+1; i++) {
            path.add(i);
            combine(n, k - 1, path, ret, i + 1);
            path.remove(path.size() - 1);
        }
    }
}