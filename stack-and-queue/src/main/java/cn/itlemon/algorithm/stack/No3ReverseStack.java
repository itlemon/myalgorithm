package cn.itlemon.algorithm.stack;

import java.util.Stack;

/**
 * 如何仅用递归函数和栈操作逆序一个栈
 * 【题目】
 * 一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别是5、4、3、2、1.将这个栈转置后，从栈顶到栈底为1、2、3、4、5，
 * 也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能使用其他数据结构。
 * 【难度】
 * ※※
 * 【测试】
 * {@link cn.itlemon.algorithm.stack.No3ReverseStackTest}
 *
 * @author jiangpingping
 * @date 2020/5/14 21:47
 */
public class No3ReverseStack {

    /**
     * 将栈底元素返回并移除
     *
     * @param stack 栈
     * @return 栈底元素
     */
    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        Integer pop = stack.pop();
        if (stack.isEmpty()) {
            return pop;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(pop);
            return last;
        }
    }

    /**
     * 反转栈
     *
     * @param stack 栈
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int element = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(element);
    }


}
