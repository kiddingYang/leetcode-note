
/**
 * Created by Administrator on 2018/10/4.
 */
public class L26_Remove_Duplicates_from_Sorted_Array {

    public static void main(String[] args) {
        int[] array = {1,1,2};
        System.out.println(new Solution().removeDuplicates2(array));
        for (int i : array) {
            System.out.print(i + ",");
        }
    }


    static class Solution {
        /**
         * 每次比较查询出重复的范围.并且把后面的值覆盖重复的值
         * 每次需要移动数组O(n^2)
         */
        public int removeDuplicates(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int left = 0;
            int right = 1;
            while (left < nums.length - 1) {
                if (right < nums.length && nums[left] == nums[right]) {
                    right++;
                } else if (right - left > 1) {
                    int i = right - left - 1;
                    while (right < nums.length) {
                        nums[right - i] = nums[right];
                        right++;
                    }
                    left++;
                    right = left + 1;
                } else {
                    left++;
                    right = left + 1;
                }
            }
            int newLen = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] <= nums[i - 1]) {
                    break;
                }
                newLen++;
            }
            return newLen;
        }


        /**
         * 每次查询和num[i]不同的值,并且放入num[i+1]中
         * O(N)
         */
        public int removeDuplicates2(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    }


}
