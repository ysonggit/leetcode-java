class MinStack {
    Stack<Integer> all_elem = new Stack<>();
    Stack<Integer> min_elem = new Stack<>();
    public void push(int x) {
        all_elem.push(x);
        if(min_elem.empty() || x <= min_elem.peek()){
            min_elem.push(x);
        }
    }

    public void pop() {
        if(all_elem.empty()) return;
        int num_to_pop = all_elem.peek();
        if( num_to_pop == min_elem.peek()){ // mistake: all_elem.peek() == min_elem.peek() doesnot work
            min_elem.pop();
        }
        all_elem.pop();
    }

    public int top() {
        if(all_elem.empty()) return -1;
        return all_elem.peek();
    }

    public int getMin() {
        if(min_elem.empty()) return -1;
        return min_elem.peek();
    }
}
