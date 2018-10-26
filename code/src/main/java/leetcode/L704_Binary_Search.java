package leetcode;


/**
 * Created by Administrator on 2018/10/26.
 */
public class L704_Binary_Search {

    public static void main(String[] args) {
        int search = new Solution().search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
        System.out.println(search);

    }

    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int mid = (left + right) / 2;
            while (left <= right) {
                if (nums[mid] == target)
                    return mid;
                else if (nums[mid] > target)
                    right = mid - 1;
                else
                    left = mid + 1;
                mid = (left + right) / 2;
            }
            return -1;
        }
    }

}
