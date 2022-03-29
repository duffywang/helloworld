package leetcode.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther : wangyufei
 * @date : 2021-05-28
 * <p>
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MyStack225 {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack225() {
        queue1 = new LinkedList();
        queue2 = new LinkedList();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (queue1.isEmpty()) {
            while (queue2.size() != 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else {
            while (queue1.size() != 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }

    }

    /**
     * Get the top element.
     */
    public int top() {
        Integer peek;
        if (queue1.isEmpty()) {
            while (queue2.size() != 1) {
                queue1.offer(queue2.poll());
            }
            peek = queue2.peek();
            queue1.offer(queue2.poll());
            return peek;
        } else {
            while (queue1.size() != 1) {
                queue2.offer(queue1.poll());
            }
            peek = queue1.peek();
            queue2.offer(queue1.poll());
            return peek;
        }
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack225 myStack225 = new MyStack225();
        myStack225.push(1);
        myStack225.push(2);
        myStack225.push(3);
        myStack225.push(4);
        System.out.println(myStack225.top());
        System.out.println(myStack225.pop());
        System.out.println(myStack225.pop());
    }
}
