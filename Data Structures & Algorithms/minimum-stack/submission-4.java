class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;

    public MinStack() {
         stack = new ArrayDeque();
         min = new ArrayDeque();
    }
    
    public void push(int val) {
        stack.addLast(val);
        if(min.isEmpty()){
            min.addLast(val);
        }else{
            min.addLast(Math.min(val, min.getLast()));
        }
        
    }
    
    public void pop() {
        stack.removeLast();
        min.removeLast();
        
    }
    
    public int top() {
        return stack.getLast();
        
    }
    
    public int getMin() {
        return min.getLast();
        
    }
}
