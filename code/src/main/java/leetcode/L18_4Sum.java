package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在15 3Sum的基础上在增加一层循环O(N^3)
 * @see L15_3Sum
 * Created by Administrator on 2018/10/3.
 */
public class L18_4Sum {

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1);
        System.out.println(lists);
    }

    static class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> allSolution = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            List<Integer> solution = new ArrayList<>(4);
                            solution.add(nums[i]);
                            solution.add(nums[j]);
                            solution.add(nums[left]);
                            solution.add(nums[right]);
                            allSolution.add(solution);
                            left++;
                            right--;
                            // 避免重复
                            while (left < right && nums[left] == nums[left - 1]) {
                                left++;
                            }
                            while (left < right && nums[right] == nums[right + 1]) {
                                right--;
                            }
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return allSolution;
        }
    }
}
