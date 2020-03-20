package leetcode;

import java.util.*;

/**
 * Created on 2019/4/30.
 *
 * @author Administrator
 */
public class L239_Sliding_Window_Maximum {


    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = new Solution().maxSlidingWindow2(nums, 3);
        Arrays.stream(ints).forEach(System.out::println);

    }


    static class Solution {

        /**
         * 一个直观但是复杂度不符合要求的实现
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[]{};
            }
            int[] result = new int[nums.length - k + 1];
            Queue<Integer> window = new ArrayDeque<>();
            int j = 0;
            for (int num : nums) {
                if (window.size() == k) {
                    int max = getMax(window);
                    result[j++] = max;
                    window.poll();
                    window.offer(num);
                } else {
                    window.offer(num);
                }
            }
            int max = getMax(window);
            result[j] = max;
            return result;
        }

        public int getMax(Queue<Integer> nums) {
            Iterator<Integer> iterator = nums.iterator();
            int max = Integer.MIN_VALUE;
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next > max) {
                    max = next;
                }
            }
            return max;
        }


        public int[] maxSlidingWindow2(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[]{};
            }
            int[] result = new int[nums.length - k + 1];
            Deque<Integer> deque = new LinkedList<>();
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                // 在尾部添加元素,并且保持队列的顺序为递减
                while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                    deque.removeLast();
                }
                deque.add(i);

                // 判断头部元素是否应该从队列里删除
                if (i - deque.getFirst() + 1 > k) {
                    deque.removeFirst();
                }

                // 如果移动超过K个需要记录窗口最大值
                if (i + 1 >= k) {
                    result[j++] = nums[deque.getFirst()];
                }
            }
            return result;
        }

    }

}
