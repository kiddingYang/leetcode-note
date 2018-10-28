package search;


/**
 * Created by Administrator on 2018/10/27.
 * 二分查找的几个变体,在一个有序数组中
 * <p>
 * 变体一：查找第一个值等于给定值的元素 如[1,2,3,4,4,4,5,6,7],给定4 返回3
 * 变体二：查找最后一个值等于给定值的元素 如[1,2,3,4,4,4,5,6,7]给定4 返回5
 * 变体三：查找第一个大于等于给定值的元素 如[1,2,3,4,4,4,5,6,7]给定4 返回3
 * 变体四：查找最后一个小于等于给定值的元素 如[1,2,3,4,4,4,5,6,7]给定6 返回7
 */
public class Binary_Search {


    public static void main(String[] args) {

        System.out.println(new Binary_Search().searchFirst(new int[]{1, 2, 3, 4, 4, 4, 5, 6, 7}, 7));
        System.out.println(new Binary_Search().searchLast(new int[]{1, 2, 3, 4, 4, 4, 5, 6, 7}, 9));
        System.out.println(new Binary_Search().searchFirstGreater(new int[]{2, 2, 3, 4, 4, 4, 5, 6, 7}, 1));
        System.out.println(new Binary_Search().searchLasttLess(new int[]{2, 2, 3, 4, 4, 4, 5, 6, 7}, 7));
    }


    // 变体一：查找第一个值等于给定值的元素 如[1,2,3,4,4,4,5,6,7],给定4 返回3
    public int searchFirst(int[] nums, int search) {
        int min = 0, max = nums.length - 1;
        while (min <= max) {
            int mid = (max + min) / 2;
            if (nums[mid] > search) {
                max = mid - 1;
            } else if (nums[mid] < search) {
                min = mid + 1;
            } else {
                // 如果前一个值不为search的值,说明是第一个
                if (mid == 0 || nums[mid - 1] != search) {
                    return mid;
                } else {
                    max = mid - 1;
                }
            }
        }
        return -1;
    }


    // 变体二：查找最后一个值等于给定值的元素 如[1,2,3,4,4,4,5,6,7]给定4 返回5
    public int searchLast(int[] nums, int search) {
        int min = 0, max = nums.length - 1;
        while (min <= max) {
            int mid = (max + min) / 2;
            if (nums[mid] > search) {
                max = mid - 1;
            } else if (nums[mid] < search) {
                min = mid + 1;
            } else {
                // 如果后一直值不是search的值
                if (mid == max || nums[mid + 1] != search) {
                    return mid;
                } else {
                    min = mid + 1;
                }
            }
        }
        return -1;
    }

    // 变体三：查找第一个大于等于给定值的元素 如[1,2,3,4,4,4,5,6,7]给定4 返回3
    public int searchFirstGreater(int[] nums, int search) {
        int min = 0, max = nums.length - 1;
        while (min <= max) {
            int mid = (max + min) / 2;
            if (nums[mid] < search) {
                min = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] < search) {
                    return mid;
                } else {
                    max = mid - 1;
                }
            }
        }
        return -1;
    }

    // 变体四：查找最后一个小于等于给定值的元素 如[1,2,3,4,4,4,5,6,7]给定6 返回7
    public int searchLasttLess(int[] nums, int search) {
        int min = 0, max = nums.length - 1;
        while (min <= max) {
            int mid = (max + min) / 2;
            if (nums[mid] > search) {
                max = mid - 1;
            } else {
                if (mid == max || nums[mid + 1] > search) {
                    return mid;
                } else {
                    min = mid + 1;
                }
            }
        }
        return -1;
    }


}
