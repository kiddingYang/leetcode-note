package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L47_Permutations_2 {


}

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        return null;
    }

    static void backtrack(int[] nums, int index, int len, int[] tmpResult, boolean[] used, List<List<Integer>> result) {
        if (index == len) {
            List<Integer> tmpResultList = new ArrayList<>();
            for (int i : tmpResult) {
                tmpResultList.add(i);
            }
            result.add(tmpResultList);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                tmpResult[i] = nums[i];
                backtrack(nums, index + 1, len, tmpResult, used, result);
                used[i] = false;
            }
        }
    }
}
