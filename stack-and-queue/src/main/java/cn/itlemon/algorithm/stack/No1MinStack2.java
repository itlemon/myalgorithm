package cn.itlemon.algorithm.stack;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈 —— 第二种解法
 *
 * @author jiangpingping
 * @date 2020/5/13 20:24
 */
public class No1MinStack2 {

    /**
     * 数据栈和最小值栈
     */
    private final transient Stack<Integer> dataStack;
    private final transient Stack<Integer> minStack;

    public No1MinStack2() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 入栈
     *
     * @param value 值
     */
    public void push(int value) {
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        } else {
            minStack.push(minStack.peek());
        }
        dataStack.push(value);
    }

    /**
     * 出栈
     *
     * @return 值
     */
    public int pop() {
        minStack.pop();
        return dataStack.pop();
    }

    /**
     * 获取栈中最小数据
     *
     * @return 栈中最小数据
     */
    public int getMin() {
        return minStack.peek();
    }

}
