public class Solution {
    public int calculate(String s) {
        String[] infix = toStrArray(s);
        String[] rpn = toRPN(infix);
        return evalRPN(rpn);
    }
    
    // convert an expression string to a string array (infix notation) 
private String[] toStrArray(String s) {
    Queue<String> q = new LinkedList<>();
    int n = s.length(), pos = 0;
    while (pos < n) {
        char c = s.charAt(pos);
        if (Character.isDigit(c)) {         // numbers
            int val = Character.getNumericValue(c);
            while (pos < n - 1 && Character.isDigit(s.charAt(pos + 1)))
                val = val * 10 + Character.getNumericValue(s.charAt(++pos));
            q.add(Integer.toString(val));
        } else if (OPERATORS.containsKey(Character.toString(c))) {  // operators
            q.add(Character.toString(c));
        } else if (c == '(' || c == ')') {  // parentheses
            q.add(Character.toString(c));
        }
        pos++;
    }
    // dequeue to a string array
    String[] tokens = new String[q.size()];
    for (int i = 0; i < tokens.length; i++)
        tokens[i] = q.poll();
    return tokens;
}

// convert infix notation to reverse polish notation: Shunting-yard algorithm
private String[] toRPN(String[] tokens) {
    Queue<String> q = new LinkedList<>();
    Stack<String> stack = new Stack<>();    // store operators
    for (int i = 0; i < tokens.length; i++) {
        String s = tokens[i];
        if (OPERATORS.containsKey(s)) {
            // pop stack to queue if the operator has same or smaller priority
            while (!stack.isEmpty() && !stack.peek().equals("(") 
                    && OPERATORS_PRIORITY.get(s) <= OPERATORS_PRIORITY.get(stack.peek()))
                q.add(stack.pop());                
            stack.push(s);  // push operator to stack
        } else if (s.equals("(")) {                
            stack.push(s);  // push "(" to stack
        } else if (s.equals(")")) {
            // pop all operators between "(" and ")" to queue
            while (!stack.peek().equals("("))
                q.add(stack.pop());
            stack.pop();    // remove "(" from stack
        } else {
            q.add(s);       // add number to queue
        }
    }
    // pop rest of operators in stack to queue
        while (!stack.isEmpty())
            q.add(stack.pop());
    // dequeue to a string array
            String[] rpn = new String[q.size()];
            for (int i = 0; i < rpn.length; i++)
                rpn[i] = q.poll();
        return rpn;
    }

    // evaluate reverse polish notation expression
    private int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (OPERATORS.containsKey(s)) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(OPERATORS.get(s).eval(x, y));
            } else  {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();    
    }
    
    interface Operator {
        int eval(int x, int y);
    }

    private static final Map<String, Operator> OPERATORS;
    static {
        OPERATORS = new HashMap<String, Operator>();
        OPERATORS.put("+", new Operator() { public int eval(int x, int y) {return x + y;} });
        OPERATORS.put("-", new Operator() { public int eval(int x, int y) {return x - y;} });
        OPERATORS.put("*", new Operator() { public int eval(int x, int y) {return x * y;} });
        OPERATORS.put("/", new Operator() { public int eval(int x, int y) {return x / y;} });
    }

    private static final Map<String, Integer> OPERATORS_PRIORITY;
    static {
        OPERATORS_PRIORITY = new HashMap<String, Integer>();
        OPERATORS_PRIORITY.put("+", 1);
        OPERATORS_PRIORITY.put("-", 1);
        OPERATORS_PRIORITY.put("*", 2);
        OPERATORS_PRIORITY.put("/", 2);
    }
}