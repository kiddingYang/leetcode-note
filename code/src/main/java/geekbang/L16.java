package geekbang;

/**
 * 二分查找几个变体的实现
 */
public class L16 {


    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 8, 8, 9};
//        int firstVal = findFirstVal(array, 2);
//        System.out.println(firstVal);
//        int lastVal = findLastVal(array, 3);
//        System.out.println(lastVal);
//        int firstGtVal = findFirstGtVal(array, 7);
//        System.out.println(firstGtVal);
//        int lastLtVal = findLastLtVal(array, 2);
//        System.out.println(lastLtVal);

        int[] array = new int[]{1, 3};

        int valInRing = findValInRing(array, 3);
        System.out.println(valInRing);

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
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (array[mid] == val) {
            // 判断是否是最后一个元素
            if (mid == array.length - 1 || array[mid + 1] != val) {
                return mid;
            } else {
                return findLastVal(array, mid + 1, high, val);
            }
        }
        if (array[mid] > val) {
            return findLastVal(array, low, mid - 1, val);
        }
        if (array[mid] < val) {
            return findLastVal(array, mid + 1, high, val);
        }
        return -1;
    }


    /**
     * 查找第一个大于等于给定值的元素
     */
    static int findFirstGtVal(int[] array, int val) {
        int low = 0;
        int high = array.length - 1;
        return findFirstGtVal(array, low, high, val);
    }

    private static int findFirstGtVal(int[] array, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (array[mid] >= val) {
            // 判断是否是第一个大于等于给定值的元素
            if (mid == 0 || array[mid - 1] < val) {
                return mid;
            }
            return findFirstGtVal(array, low, mid - 1, val);
        } else {
            return findFirstGtVal(array, mid + 1, high, val);
        }
    }


    /**
     * 查找最后一个小于等于给定值的元素
     */
    static int findLastLtVal(int[] array, int val) {
        int low = 0;
        int high = array.length - 1;
        return findLastLtVal(array, low, high, val);
    }

    private static int findLastLtVal(int[] array, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (array[mid] <= val) {
            if (mid == array.length - 1 || array[mid + 1] > val) {
                return mid;
            }
            return findLastLtVal(array, mid + 1, high, val);
        }
        return findLastLtVal(array, low, mid - 1, val);
    }


    /**
     * 思考题：如果有序数组是一个循环有序数组,查找指定元素
     */
    static int findValInRing(int[] array, int val) {
        int low = 0;
        int high = array.length - 1;
        return findValInRing(array, low, high, val);
    }

    /**
     * 循环数组的一个性质：以数组中间点为分区，会将数组分成一个有序数组和一个循环有序数组
     * 如果首元素小于 mid，说明前半部分是有序的，后半部分是循环有序数组；
     * 如果首元素大于 mid，说明后半部分是有序的，前半部分是循环有序的数组；
     * 如果目标元素在有序数组范围中，使用二分查找；
     * 如果目标元素在循环有序数组中，设定数组边界后，使用以上方法继续查找。
     */
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


}
