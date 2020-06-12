package cn.itlemon.algorithm.queue;

import cn.itlemon.algorithm.model.animals.AbstractPet;
import cn.itlemon.algorithm.model.animals.Cat;
import cn.itlemon.algorithm.model.animals.Dog;
import cn.itlemon.algorithm.model.animals.PetType;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 猫狗队列
 * 【题目】
 * 实现一种猫狗队列的结构，要求如下：
 * 1、用户可以调用add方法将cat类或者dog类的实例放入到队列中
 * 2、用户可以调用pollAll方法，将队列中所有的实例按照进队列的顺序依次弹出
 * 3、用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出
 * 4、用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出
 * 5、用户可以调用isEmpty方法，检查队列中是否还有dog或者cat的实例
 * 6、用户可以调用isDogEmpty方法，检查队列中是否还有dog类的实例
 * 7、用户可以调用isCatEmpty方法，检查队列中是否还有cat类的实例
 * 【难度】
 * ※
 *
 * @author jiangpingping
 * @date 2020/6/11 22:52
 */
public class No4CatDogQueue {

    /**
     * 抽象动物入队实体
     */
    static class PetEnterQueue {

        private AbstractPet pet;
        private long count;

        public PetEnterQueue(AbstractPet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public AbstractPet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public PetType getEnterPetType() {
            return pet.getType();
        }
    }

    static class CatDogQueue {

        private final Queue<PetEnterQueue> dogQueue;
        private final Queue<PetEnterQueue> catQueue;
        private long count;

        public CatDogQueue() {
            dogQueue = new LinkedBlockingDeque<>();
            catQueue = new LinkedBlockingDeque<>();
            count = 0;
        }

        /**
         * 猫狗入队
         *
         * @param pet 动物
         */
        public void add(AbstractPet pet) {
            if (PetType.cat.equals(pet.getType())) {
                catQueue.add(new PetEnterQueue(pet, count++));
            } else if (PetType.dog.equals(pet.getType())) {
                dogQueue.add(new PetEnterQueue(pet, count++));
            } else {
                throw new RuntimeException("Error, not cat or dog!");
            }
        }

        /**
         * 猫狗依次出队
         *
         * @return 猫或狗
         */
        public AbstractPet pollAll() {
            if (!isCatEmpty() && !isDogEmpty()) {
                assert dogQueue.peek() != null;
                assert catQueue.peek() != null;
                if (dogQueue.peek().getCount() < catQueue.peek().getCount()) {
                    return dogQueue.poll().getPet();
                } else {
                    return catQueue.poll().getPet();
                }
            } else if (!isCatEmpty()) {
                return catQueue.poll().getPet();
            } else if (!isDogEmpty()) {
                return dogQueue.poll().getPet();
            } else {
                throw new RuntimeException("Error, queue is empty!");
            }
        }

        /**
         * 猫出队
         *
         * @return 猫
         */
        public Cat pollCat() {
            if (!isCatEmpty()) {
                return (Cat) catQueue.poll().getPet();
            } else {
                throw new RuntimeException("Error, cat queue is empty!");
            }
        }

        /**
         * 狗出队
         *
         * @return 狗
         */
        public Dog pollDog() {
            if (!isDogEmpty()) {
                return (Dog) dogQueue.poll().getPet();
            } else {
                throw new RuntimeException("Error, dog queue is empty!");
            }
        }

        /**
         * 猫狗队列是否为空
         *
         * @return 是否为空
         */
        public boolean isEmpty() {
            return dogQueue.isEmpty() && catQueue.isEmpty();
        }

        /**
         * 队列中猫是否为空
         *
         * @return 是否为空
         */
        public boolean isCatEmpty() {
            return catQueue.isEmpty();
        }

        /**
         * 队列中狗是否为空
         *
         * @return 是否为空
         */
        public boolean isDogEmpty() {
            return dogQueue.isEmpty();
        }

    }

}
