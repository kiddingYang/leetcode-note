package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L39_组合总和 {


    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().combinationSum(new int[]{2, 3, 5, 7}, 7);
        System.out.println(result);

    }


    static class Solution {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            boolean[] used = new boolean[candidates.length];
            List<List<Integer>> result = new ArrayList<>();
            backtrack(0, candidates.length, candidates, target, used, 0, new LinkedList<>(), result);
            return result;
        }

        private void backtrack(int deep, int len, int[] candidates, int target, boolean[] used, int sum, LinkedList<Integer> combine, List<List<Integer>> result) {
            if (deep == len) {
                return;
            }
            for (int i = 0; i < candidates.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    combine.add(candidates[i]);
                    sum = sum + candidates[i];
                    if (sum == target) {
                        result.add(new ArrayList<>(combine));
                        break;
                    }
                    backtrack(deep + 1, len, candidates, target, used, sum, combine, result);
                    used[i] = false;
                    Integer last = combine.removeLast();
                    sum = sum - last;
                }
            }
        }

    }
}
