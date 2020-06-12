package cn.itlemon.algorithm.stack;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 * 【题目】
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只需申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。
 * 如何完成排序？
 * 【难度】
 * ※
 *
 * @author jiangpingping
 * @date 2020/6/12 16:19
 */
public class No5StackSort {

    /**
     * 将栈进行排序
     *
     * @param stack 待排序的栈
     */
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> helper = new Stack<>();
        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            while (!helper.isEmpty() && helper.peek() < current) {
                stack.push(helper.pop());
            }
            helper.push(current);
        }
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
    }

}
