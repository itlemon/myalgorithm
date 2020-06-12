package cn.itlemon.algorithm.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * {@link No5StackSort}
 *
 * @author jiangpingping
 * @date 2020/6/12 17:35
 */
public class No5StackSortTest {

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.add(9);
        stack.add(3);
        stack.add(5);
        stack.add(7);
        stack.add(4);
        stack.add(1);
        stack.add(8);
        No5StackSort.sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
