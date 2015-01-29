public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return null;
        }
        
        String[] strs = path.split("/");
        
        Stack<String> s = new Stack<String>();
        
        for(String str:strs){
           if (str.equals("..")) {
              if(!s.isEmpty()){
                  s.pop();
              }
           }else if (!str.equals(".")&&!str.equals("")){
               s.push(str);
           }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.insert(0, s.pop());
            sb.insert(0, '/');
        }
        
        if(sb.length() == 0){
            sb.append("/");
        }
        
        return sb.toString();
    }
}