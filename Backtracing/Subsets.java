public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        
        if (S == null) {
            return ret;
        }
        
        Arrays.sort(S);
        subsetsHelper(S, path, ret, 0);
        return ret;
    }
    
    public void subsetsHelper (int[] S, List<Integer> path, List<List<Integer>> ret, int index) {
        ret.add(new ArrayList<Integer> (path));
        for (int i = index; i < S.length; i++) {
            path.add(S[i]);
            subsetsHelper(S, path, ret, i + 1);
            path.remove(path.size() - 1); //This is to remove the last element so that we could do DFS.
        }
    }
}