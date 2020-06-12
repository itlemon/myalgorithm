package cn.itlemon.algorithm.queue;

import cn.itlemon.algorithm.model.animals.Cat;
import cn.itlemon.algorithm.model.animals.Dog;
import org.junit.Test;

/**
 * {@link No4CatDogQueue}
 *
 * @author jiangpingping
 * @date 2020/6/12 16:04
 */
public class No4CatDogQueueTest {

    @Test
    public void test() {
        No4CatDogQueue.CatDogQueue catDogQueue = new No4CatDogQueue.CatDogQueue();
        catDogQueue.add(new Cat());
        catDogQueue.add(new Dog());
        catDogQueue.add(new Dog());
        catDogQueue.add(new Cat());
        catDogQueue.add(new Cat());
        // 测试全部出队
        System.out.println("==========测试pollAll");
        System.out.println(catDogQueue.pollAll());
        System.out.println(catDogQueue.pollAll());
        System.out.println(catDogQueue.pollAll());
        System.out.println(catDogQueue.pollAll());
        System.out.println(catDogQueue.pollAll());
        catDogQueue.add(new Cat());
        catDogQueue.add(new Dog());
        catDogQueue.add(new Dog());
        catDogQueue.add(new Cat());
        catDogQueue.add(new Cat());
        // 测试仅出队猫
        System.out.println("==========测试pollCat");
        System.out.println(catDogQueue.pollCat());
        System.out.println(catDogQueue.pollCat());
        System.out.println(catDogQueue.pollCat());
        // 测试仅出队狗
        System.out.println("==========测试pollDog");
        System.out.println(catDogQueue.pollDog());
        System.out.println(catDogQueue.pollDog());
        // 测试为空
        System.out.println("==========测试isEmpty");
        System.out.println(catDogQueue.isEmpty());
        System.out.println(catDogQueue.isDogEmpty());
        System.out.println(catDogQueue.isCatEmpty());
    }

}
