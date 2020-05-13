package cn.itlemon.algorithm.queue;

import org.junit.Test;

/**
 * {@link No2StackQueue}
 *
 * @author jiangpingping
 * @date 2020/5/13 22:13
 */
public class No2StackQueueTest {

    @Test
    public void test() {
        No2StackQueue queue = new No2StackQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}
