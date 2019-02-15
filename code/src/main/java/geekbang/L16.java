package geekbang;

/**
 * 二分查找几个变体的实现
 */
public class L16 {


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 2, 2, 3, 3, 3, 4, 5, 6};
        int firstVal = findFirstVal(array, 2);
        System.out.println(firstVal);
    }


    /**
     * 查找第一个值等于给定值的元素
     *
     * @return 返回第一个值的索引, 如果没有返回-1
     */
    static int findFirstVal(int[] array, int val) {
        int low = 0;
        int high = array.length - 1;
        return findFirstVal(array, low, high, val);
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


    /**
     * 查询最后一个给定值的元素
     *
     * @return 返回给定值最后值的索引, 如果没有返回-1
     */
    static int findLastVal(int[] array, int val) {
        int low = 0;
        int high = array.length - 1;
        return findLastVal(array, low, high, val);
    }

    private static int findLastVal(int[] array, int low, int high, int val) {
        if (low < high) {
            return -1;
        }
        int mid = low + (high + low) / 2;
        if (array[mid] == val) {
            // 判断是否是最后一个元素
            if (mid == array.length - 1 || array[mid + 1] != val) {
                return mid;
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
