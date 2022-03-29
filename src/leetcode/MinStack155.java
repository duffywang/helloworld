package leetcode;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 解释：每次push两个值，一个是push的值，另一个是当前保留的最小值
 *
 * @auther : wangyufei
 * @date : 2020-01-31
 **/
public class MinStack155 {
    private Stack<Integer> stack;


    public static void main(String[] args) {
        MinStack155 minStack = new MinStack155();
        minStack.push(-2);
        minStack.push(-1);
        minStack.push(-8);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }

    /**
     * initialize your data structure here.
     */
    public MinStack155() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            if (x < stack.peek()) {
                stack.push(x);
                stack.push(x);
            } else {
                Integer temp = stack.peek();
                stack.push(x);
                stack.push(temp);
            }
        }

    }

    public void pop() {
        stack.pop();
        stack.pop();

    }

    public int top() {
        return stack.get(stack.size() - 2);
    }

    public int getMin() {
        return stack.peek();
    }
}
