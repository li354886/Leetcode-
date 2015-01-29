public class Solution {
    public boolean isValid(String s) {
        if(s == null){
            return false;
        }
        
        int len = s.length();
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            switch(c){
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                case ']':
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                case '}':
                    if(!stack.isEmpty() && stack.peek() == '{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
            }
        }
        
        return stack.isEmpty();
        
    }
}