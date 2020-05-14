package cn.itlemon.algorithm.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * {@link No3ReverseStack}
 *
 * @author jiangpingping
 * @date 2020/5/14 23:37
 */
public class No3ReverseStackTest {

    @Test
    public void test() {
        Stack<Integer> integers = new Stack<>();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        No3ReverseStack.reverse(integers);
        while (!integers.isEmpty()) {
            System.out.println(integers.pop());
        }
    }
}
