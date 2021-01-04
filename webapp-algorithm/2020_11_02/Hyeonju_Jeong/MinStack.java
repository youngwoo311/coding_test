package exam;

import java.util.*;

//https://leetcode.com/problems/min-stack/
//Complete
public class MinStack {

    private Stack<Integer> stack;

    private List<Integer> list;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(1);
        minStack.push(5);
        minStack.pop();
        minStack.push(7);
        minStack.push(0);
        minStack.pop();
        minStack.push(-1);
        minStack.push(10);
        minStack.push(10);

        System.out.println(minStack.getMin());
    }

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        list = new ArrayList<>();
    }

    public void push(int x) {
        stack.push(x);
        list.add(x);
        Collections.sort(list);
    }

    public void pop() {
        int pop = stack.pop();
        list.remove(Integer.valueOf(pop));
    }

    public int top() {
        int top = stack.pop();
        stack.push(top);
        return top;
    }

    public int getMin() {

//  return a min value
        return list.get(0);
    }
}
