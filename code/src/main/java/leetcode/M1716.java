package leetcode;

import java.util.HashSet;
import java.util.Set;

public class M1716 {

    private static Set<Integer> array = new HashSet<>();

    public static void main(String[] args) {

        int massage = new Solution().massage(new int[]{1,2});
        System.out.println(massage);
        array.forEach(System.out::print);

    }

    static class Solution {

        public int massage(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }

            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }

            return dp[nums.length - 1];
        }

    }

}
