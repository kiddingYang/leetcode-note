package leetcode;


/**
 * Created by Administrator on 2018/10/27.
 */
public class L35_Search_Insert_Position {

    public static void main(String[] args) {
        int searchInsert = new Solution().searchInsert(new int[]{1}, 1);
        System.out.println(searchInsert);
    }


    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int min = 0, max = nums.length - 1;
            if (nums[max] < target) {
                return max + 1;
            }
            if (nums[min] > target) {
                return 0;
            }
            while (min <= max) {
                if (max - min == 1) {
                    if (nums[min] == target) {
                        return min;
                    }
                    if (nums[max] == target) {
                        return max;
                    }
                    return min + 1;
                }
                int mid = (min + max) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    max = mid;
                } else if (nums[mid] < target) {
                    min = mid;
                }
            }
            return -1;
        }
    }

}
