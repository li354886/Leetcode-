public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        
        if (n == 0) {
            return ret;
        }
        
        dfs(n, n, new StringBuilder(), ret);
        
        return ret;
    }
    
    public void dfs(int left, int right, StringBuilder sb, List<String> ret){
        if (left == 0 && right == 0) {
            ret.add(sb.toString());
            return;
        }
        
        if (left < 0 || right < 0 || left < right) {
            return;
        }
        
        dfs(left - 1, right, sb.append(")"), ret);
        sb.deleteCharAt(sb.length() - 1);
        
        dfs(left, right - 1, sb.append("("), ret);
        sb.deleteCharAt(sb.length() - 1);
        
        
    }
}