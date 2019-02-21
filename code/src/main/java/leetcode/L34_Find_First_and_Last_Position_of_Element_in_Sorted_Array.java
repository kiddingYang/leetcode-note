package leetcode;

public class L34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {


    //[0,0,0,0,1,2,3,3,4,5,6,6,7,8,8,8,9,9,10,10,11,11]
    //0
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 0, 1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 8, 8, 9, 9, 10, 10, 11, 11};
        int[] val = new L34_Find_First_and_Last_Position_of_Element_in_Sorted_Array().searchRange(nums, 0);
        System.out.println(val[0] + ":" + val[1]);
    }


    public int[] searchRange(int[] nums, int target) {
        int firstIndex = findFirstVal(nums, 0, nums.length - 1, target);
        int lastIndex = findLastVal(nums, firstIndex + 1, nums.length - 1, target);
        if (lastIndex == -1) {
            return new int[]{firstIndex, firstIndex};
        }
        return new int[]{firstIndex, lastIndex};
    }


    static int findFirstVal(int[] array, int low, int high, int val) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (array[mid] == val) {
            // 判断是否是第一个
            if (mid == 0 || array[mid - 1] != val) {
                return mid;
            } else {
                return findFirstVal(array, low, mid - 1, val);
            }
        } else if (array[mid] > val) {
            return findFirstVal(array, low, mid - 1, val);
        } else {
            return findFirstVal(array, mid + 1, high, val);
        }
    }


    static int findLastVal(int[] array, int low, int high, int val) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (array[mid] == val) {
            // 判断是否是最后一个
            if (mid == high || array[mid + 1] != val) {
                return mid;
            } else {
                return findLastVal(array, mid + 1, high, val);
            }
        } else if (array[mid] > val) {
            return findLastVal(array, low, mid - 1, val);
        } else {
            return findLastVal(array, mid + 1, high, val);
        }
    }

}
