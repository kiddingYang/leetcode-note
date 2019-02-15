package geekbang;

/**
 * 二分查找
 */
public class L15 {


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 7, 10};
        int search = bSearch(array, array.length, 10);
        System.out.println(search);
        double sqrt = sqrt(5);
        System.out.println(sqrt);

    }

    /**
     * 一个二分查找的简单实现
     *
     * @param array 查找的数组
     * @param n     数组长度
     * @param value 查找的值
     * @return 如果查找到该值返回, 否则返回-1
     */
    static int search(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == value) {
                return mid;
            }
            if (array[mid] > value) {
                high = mid - 1;
            }
            if (array[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归的方式实现
     */
    static int bSearch(int[] array, int n, int value) {
        return bSearch(array, 0, n - 1, value);
    }

    private static int bSearch(int[] array, int low, int high, int value) {

        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (array[mid] == value) {
            return mid;
        }
        if (array[mid] > value) {
            return bSearch(array, low, mid - 1, value);
        }
        if (array[mid] < value) {
            return bSearch(array, mid + 1, high, value);
        }
        return -1;
    }


    /**
     * 二分法求一个数的平方根,精确到小数点6位
     */
    static double sqrt(int n) {
        double low = 0;
        double high = n;
        double mid = low + ((high - low) / 2);
        int point = 0;
        while (mid * mid != n && point < 6) {
            mid = low + ((high - low) / 2);
            if (mid * mid - n < 0) {
                low = mid;
            }
            if (mid * mid - n > 0) {
                high = mid;
            }
            point++;
        }
        return mid;
    }


}
