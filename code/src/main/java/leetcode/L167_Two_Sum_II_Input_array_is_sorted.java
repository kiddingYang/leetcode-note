package leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/10/27.
 */
public class L167_Two_Sum_II_Input_array_is_sorted {

    public static void main(String[] args) {

        int[] ints = new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        Arrays.stream(ints).forEach(System.out::println);

    }


    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[]{++left, ++right};
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return new int[]{};
        }
    }

}
