package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/10/2.
 * 先排序。
 * 外循环i纪录第一个数字，内循环采用2 pointer的方法，当sum>0，right往左移，sum < 0,left往右移。
 * 碰到sum ＝ nums[i] + nums[right] + nums[left]时，把三个数字存到solution里，并把solution存到最外面的allSolution里面。
 * 注意存在重复结果去重
 */
public class L15_3Sum {

    public static void main(String[] args) {
        List<List<Integer>> allSolution = new Solution().threeSum(new int[]{-2, 0, 3, -1, 4, 0, 3, 4, 1, 1, 1, -3, -5, 4, 0});
        System.out.println(allSolution);
    }


    static class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> allSolution = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i >= 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int result = nums[i] + nums[left] + nums[right];
                    if (result == 0) {
                        List<Integer> solution = new ArrayList<>(3);
                        solution.add(nums[i]);
                        solution.add(nums[left]);
                        solution.add(nums[right]);
                        allSolution.add(solution);
                        // 查找下一组
                        left++;
                        right--;
                        // 避免重复
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (result < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return allSolution;
        }
    }
}
