public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return ret;
        }
        
        List<Integer> path = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        
        comSum(candidates, target, path, ret, 0);
        return ret;
    }
    
    public void comSum (int[] candidates, int target, List<Integer>path, List<List<Integer>> ret, int index) {
         if (target == 0) {
             ret.add(new ArrayList<Integer> (path));
             return;
         }
         
         if (target < 0) {
             return;
         }
         
         int len = candidates.length;
         for (int i = index; i < len; i++) {
             int num = candidates[i];
             path.add(num);
             comSum(candidates, target - num, path, ret, i); //We could add the same number many times so here is i not i+1
             path.remove(path.size() - 1);
         }
    }
}