package MinStack;

import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> minData = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        data.push(x);
        if(minData.isEmpty() || minData.peek() >= x) {
            minData.push(x);
        }
    }

    public void pop() {
        int curData = data.pop();
        if(curData == minData.peek()) {
            minData.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minData.peek();
    }
}

