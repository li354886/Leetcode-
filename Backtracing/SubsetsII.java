public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        if (num == null) {
            return ret;
        }
        
        Arrays.sort(num); //This is Arrays not Array
        dfs(num, new ArrayList<Integer>(), ret, 0);
        return ret;
    }
    
    public void dfs (int[] num, List<Integer> path, List<List<Integer>> ret, int index) {
        ret.add(new ArrayList<Integer> (path));
        
        for (int i = index; i < num.length; i++) {
            if (i > index && num[i] == num[i - 1]) {
                continue; //if 1 1 1 2, index at first 1, we skip the next 2
            }
            path.add(num[i]);
            dfs(num, path, ret, i + 1); //let next node be the index to do recursive
            path.remove(path.size() - 1);
        }
    }
}