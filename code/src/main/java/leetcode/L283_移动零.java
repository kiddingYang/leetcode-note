package leetcode;

import java.util.Arrays;

public class L283_移动零 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);

    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            int slow = 0;
            int fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    swap(nums, slow, fast);
                    slow++;
                    fast++;
                } else {
                    fast++;
                }
            }
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

}
