package leetcode;

/**
 * Created by Administrator on 2018/10/24.
 */
public class L852_Peak_Index_in_a_Mountain_Array {

    public static void main(String[] args) {

        int i = new Solution().peakIndexInMountainArray(new int[]{0, 2, 1, 0});
        System.out.println(i);
    }

    /**
     * 使用二分查找,动态指定left和right
     */
    static class Solution {
        public int peakIndexInMountainArray(int[] A) {
            int left = 0, right = A.length;
            int min = 0;
            while (left < right) {
                min = (left + right) / 2;
                if (A[min] > A[min - 1] && A[min] < A[min + 1]) {
                    left = min;
                } else if (A[min] < A[min - 1] && A[min] > A[min + 1]) {
                    right = min;
                } else {
                    break;
                }
            }
            return min;
        }
    }
}
