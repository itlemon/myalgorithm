package cn.itlemon.algorithm.queue;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组（滑动窗口）
 * 【题目】
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                  最大值
 * ---------------              -----
 * [1  3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 【难度】
 * ※
 *
 * @author jiangpingping
 * @date 2020/6/14 19:16
 */
public class No6SlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return null;
        }
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekFirst() == i - k) {
                queue.pollFirst();
            }
            if (i >= k - 1) {
                result[index++] = nums[queue.peekFirst()];
            }
        }
        return result;
    }

}
