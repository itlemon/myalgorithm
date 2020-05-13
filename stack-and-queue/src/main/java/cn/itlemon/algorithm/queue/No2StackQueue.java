package cn.itlemon.algorithm.queue;

import java.util.Stack;

/**
 * 两个栈组成队列
 * 【题目】
 * 编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）
 * 【难度】
 * ※※
 * 【测试】
 * {@link cn.itlemon.algorithm.queue.No2StackQueueTest}
 *
 * @author jiangpingping
 * @date 2020/5/13 21:32
 */
public class No2StackQueue {

    /**
     * 压栈和弹栈
     */
    private final transient Stack<Integer> pushStack;
    private final transient Stack<Integer> popStack;

    public No2StackQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /**
     * 将push栈的元素压入到pop栈中，只能在pop栈为空的时候操作，否则会出现错误
     */
    private void pushStack2PopStack() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    /**
     * 入队
     *
     * @param value 队头值
     */
    public void add(int value) {
        pushStack.push(value);
        pushStack2PopStack();
    }

    /**
     * 出队
     *
     * @return 队头值
     */
    public int poll() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        pushStack2PopStack();
        return popStack.pop();
    }

    /**
     * 获取队头值
     *
     * @return 队头值
     */
    public int peek() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        pushStack2PopStack();
        return popStack.peek();
    }

}
