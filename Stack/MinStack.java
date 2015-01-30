class MinStack {
    
    Stack<Integer> elements = new Stack<Integer>();
    Stack<Integer> minstack = new Stack<Integer>();
    public void push(int x) {
        elements.push(x);
        if (minstack.isEmpty() || x <= minstack.peek()) {
            minstack.push(x);
        }
    }

    public void pop() {
        if(elements.isEmpty()){
            return;
        }
        if(elements.peek().equals(minstack.peek())){
            minstack.pop();
        }
        elements.pop();
    }

    public int top() {
        return elements.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
