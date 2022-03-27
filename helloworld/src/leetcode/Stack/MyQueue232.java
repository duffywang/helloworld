package leetcode.Stack;

import java.util.Stack;

/**
 * @auther : wangyufei
 * @date : 2021-06-06
 * <p>
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MyQueue232 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stack2.isEmpty()) return stack2.pop();
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();

    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack2.isEmpty()) return stack2.peek();
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue232 myQueue232 = new MyQueue232();
        myQueue232.push(1);
        myQueue232.push(2);
        myQueue232.push(3);
        myQueue232.push(4);
        System.out.println(myQueue232.pop());
        myQueue232.push(5);
        System.out.println(myQueue232.pop());
        System.out.println(myQueue232.pop());
        System.out.println(myQueue232.peek());


    }
}
