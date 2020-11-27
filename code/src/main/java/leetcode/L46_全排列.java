package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L46_全排列 {


    public static void main(String[] args) {

        new Solution().permute(new int[] {1,2,3});

    }


    static class Solution {


        public List<List<Integer>> permute(int[] nums) {
            boolean[] used = new boolean[nums.length];
            ArrayList<List<Integer>> result = new ArrayList<>();
            backtrace(0, nums.length, nums, new LinkedList<>(), result, used);
            System.out.println(result);
            return result;
        }


        private void backtrace(int deep, int len, int[] nums, LinkedList<Integer> path, List<List<Integer>> result, boolean[] used) {
            if (deep == len) {
                result.add(new ArrayList<>(path));
            }
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    path.add(nums[i]);
                    used[i] = true;
                    backtrace(deep + 1, len, nums, path, result, used);
                    used[i] = false;
                    path.removeLast();
                }
            }
        }

    }

}
