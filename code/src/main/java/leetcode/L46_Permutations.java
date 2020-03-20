package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L46_Permutations {


    public static void main(String[] args) {

        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, nums.length, new int[nums.length], new boolean[nums.length], result);
        return result;
    }

    static void backtrack(int[] nums, int k, int n, int[] tmpResult, boolean[] used, List<List<Integer>> result) {
        if (k == n) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : tmpResult) {
                tmp.add(num);
            }
            result.add(tmp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                tmpResult[k] = nums[i];
                backtrack(nums, k + 1, n, tmpResult, used, result);
                used[i] = false;
            }
        }
    }

}
