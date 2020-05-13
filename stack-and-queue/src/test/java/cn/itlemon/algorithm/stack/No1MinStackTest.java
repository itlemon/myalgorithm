package cn.itlemon.algorithm.stack;

import org.junit.Test;

/**
 * {@link No1MinStack}
 *
 * @author jiangpingping
 * @date 2020/5/13 21:13
 */
public class No1MinStackTest {

    @Test
    public void test() {
        No1MinStack stack = new No1MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
    }

}
