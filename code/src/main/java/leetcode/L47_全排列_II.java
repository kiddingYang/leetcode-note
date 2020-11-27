package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L47_全排列_II {

    public static void main(String[] args) {
        new Solution().permuteUnique(new int[]{1,1, 2, 3});
    }


    static class Solution {

        public List<List<Integer>> permuteUnique(int[] nums) {

            boolean[] used = new boolean[nums.length];
            ArrayList<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            permuteUnique(0, nums.length, nums, used, new LinkedList<>(), result);
            System.out.println(result);
            return result;
        }


        private void permuteUnique(int deep, int len, int[] nums, boolean[] used, LinkedList<Integer> path, List<List<Integer>> result) {
            if (deep == len) {
                result.add(new LinkedList<>(path));
            }

            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                if (!used[i]) {
                    path.add(nums[i]);
                    used[i] = true;
                    permuteUnique(deep + 1, len, nums, used, path, result);
                    path.removeLast();
                    used[i] = false;
                }
            }
        }

    }
}
