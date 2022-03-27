package swordoffer;

import java.util.Stack;

/**
 * @auther : wangyufei
 * @date : 2020-07-18
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 栈是先进后出的，先把stack2的pop完，然后再加stack1进到stack2
 * 队列是先进先出的
 **/
public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()){
            if (stack1.isEmpty())return -1;
            else {
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }else {
            //stack2的存量
            return stack2.pop();
        }

    }

    public static void main(String[] args) {

    }
}
