class MyStack {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    Queue<Integer> q_empty, q_inuse;
    // Push element x onto stack.
    public void push(int x) {
        if(q1.isEmpty() && q2.isEmpty()) {
            q1.offer(x);
            return;
        }
        q_inuse = q1.isEmpty() ? q2 : q1;
        q_inuse.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(empty()) return;
        q_empty = q1.isEmpty() ? q1 : q2;
        q_inuse = q1.isEmpty() ? q2 : q1;
        while(q_inuse.size()>1){
            q_empty.offer(q_inuse.poll());
        }
        q_inuse.poll();
    }

    // Get the top element.
    public int top() {
        q_empty = q1.isEmpty() ? q1 : q2;
        q_inuse = q1.isEmpty() ? q2 : q1;
        while(q_inuse.size()>1){
            q_empty.offer(q_inuse.poll());
        }
        int element = q_inuse.poll();
        q_empty.offer(element);
        return element;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
