package sort;


import java.util.Arrays;

/**
 * 希尔排序
 * 把记录按步长 gap 分组，对每组记录采用直接插入排序方法进行排序。
 * 随着步长逐渐减小，所分成的组包含的记录越来越多，当步长的值减小到 1 时，整个数据合成为一组，构成一组有序记录，则完成排序。
 * Created by Administrator on 2018/10/15.
 */
public class Shell_Sort {

    public static void main(String[] args) {

        new Shell_Sort().sort(new int[]{9, 1, 2, 5, 7, 4, 8, 6, 3, 5});
    }


    private int[] sort(int[] nums) {

        for (int gap = nums.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < nums.length; i++) {

                int j;
                int tmp = nums[i];

                for (j = i - gap; j >= 0 && tmp < nums[j]; j -= gap) {
                    nums[j + gap] = nums[j];
                }
                nums[j + gap] = tmp;
            }
            Arrays.stream(nums).forEach(System.out::print);
            System.out.println();
            if (gap == 1) {
                break;
            }
        }

        return nums;
    }
}
