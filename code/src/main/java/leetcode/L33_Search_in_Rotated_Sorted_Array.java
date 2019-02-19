package leetcode;

public class L33_Search_in_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        return findValInRing(nums, low, high, target);
    }
    private static int findValInRing(int[] array, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (array[mid] == val) {
            return mid;
        }
        if (array[low] > array[mid]) {
            int firstVal = findFirstVal(array, mid + 1, high, val);
            if (firstVal == -1) {
                return findValInRing(array, low, mid - 1, val);
            }
            return firstVal;
        }

        if (array[low] < array[mid]) {
            int firstVal = findFirstVal(array, low, mid - 1, val);
            if (firstVal == -1) {
                return findValInRing(array, mid + 1, high, val);
            }
            return firstVal;
        }

        if (array[low] == array[mid] && array[mid] == val) {
            return mid;
        } else if (array[low] == array[mid] && array[mid] != val) {
            return findValInRing(array, mid + 1, high, val);
        }
        return -1;
    }
    private static int findFirstVal(int[] array, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (array[mid] == val) {
            // 增加条件判断是否是第一个
            if (mid == 0 || array[mid - 1] != val) {
                return mid;
            } else {
                return findFirstVal(array, low, mid - 1, val);
            }
        }
        if (array[mid] > val) {
            return findFirstVal(array, low, mid - 1, val);
        }
        if (array[mid] < val) {
            return findFirstVal(array, mid + 1, high, val);
        }
        return -1;
    }

}
