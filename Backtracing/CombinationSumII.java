public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        
        if (num == null || num.length == 0) {
            return ret;
        }
        
        Arrays.sort(num);
        comSum(num, target, path, ret, 0);
        
        return ret;
    }
    
    public void comSum (int[] num, int target, List<Integer> path, List<List<Integer>> ret, int index) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            ret.add(new ArrayList<Integer> (path));
        }
        
        int pre = -1;
        for (int i = index; i < num.length; i++) {
            if (num[i] == pre) {
                continue;
            }
            
            pre = num[i];
            
            path.add(num[i]);
            comSum(num, target - num[i], path, ret, i + 1);
            path.remove(path.size() - 1);
        }
    }
}