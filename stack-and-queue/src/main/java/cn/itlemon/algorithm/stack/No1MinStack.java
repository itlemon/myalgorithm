package cn.itlemon.algorithm.stack;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 * 【题目】
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * 【要求】
 * 1.pop、push、getMin操作的时间复杂度都是O(1)
 * 2.设计的栈类型可以使用现成的栈结构
 * 【难度】
 * ※
 *
 * @author jiangpingping
 * @date 2020/5/13 19:41
 */
public class No1MinStack {

    /**
     * 数据栈和最小值栈
     */
    private final transient Stack<Integer> dataStack;
    private final transient Stack<Integer> minStack;

    public No1MinStack() {
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
        }
        dataStack.push(value);
    }

    /**
     * 出栈
     *
     * @return 值
     */
    public int pop() {
        // 原生pop方法里面，如果栈为空，将抛出EmptyStackException异常
        Integer value = dataStack.pop();
        if (value.equals(minStack.peek())) {
            minStack.pop();
        }
        return value;
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
