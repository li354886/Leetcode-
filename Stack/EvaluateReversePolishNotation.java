public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("+")){
                int val = Integer.parseInt(stack.pop())+Integer.parseInt(stack.pop());
                stack.push(String.valueOf(val));
            }else if(tokens[i].equals("-")){
                int val1 = Integer.parseInt(stack.pop());
                int val2 = Integer.parseInt(stack.pop());
                int val = val2 -val1;
                stack.push(String.valueOf(val));
            }else if(tokens[i].equals("*")){
                int val = Integer.parseInt(stack.pop())*Integer.parseInt(stack.pop());
                stack.push(String.valueOf(val));
            }else if(tokens[i].equals("/")){
                int val1 = Integer.parseInt(stack.pop());
                int val2 = Integer.parseInt(stack.pop());
                int val  = val2 / val1;
                stack.push(String.valueOf(val));
            }else{
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}