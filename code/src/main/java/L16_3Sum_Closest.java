
import java.util.Arrays;

/**
 * 同L15题
 * @see L15_3Sum.Solution#threeSum(int[])
 */
public class L16_3Sum_Closest {
    public static void main(String[] args) {
        int sum = new Solution().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(sum);
    }

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {

            int min = Integer.MAX_VALUE;
            int result = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i >= 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(sum - target) < Math.abs(min)) {
                        min = sum - target;
                        result = sum;
                    }
                    if (sum == target) {
                        return target;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }

                }
            }
            return result;
        }
    }
}
