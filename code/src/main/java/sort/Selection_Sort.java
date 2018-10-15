package sort;

import java.util.Arrays;

/**
 * 选择排序
 * 第一次从R[0]~R[n-1]中选取最小值，与R[0]交换，第二次从R[1]~R[n-1]中选取最小值，与R[1]交换，....，
 * 第i次从R[i-1]~R[n-1]中选取最小值，与R[i-1]交换，.....，第n-1次从R[n-2]~R[n-1]中选取最小值，
 * 与R[n-2]交换，总共通过n-1次，得到一个按排序码从小到大排列的有序序列。
 * Created by Administrator on 2018/10/15.
 */
public class Selection_Sort {


    public static void main(String[] args) {

        new Selection_Sort().sort(new int[]{5, 4, 2, 1, 3});
    }


    private int[] sort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int tmp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = tmp;
            }
            Arrays.stream(nums).forEach(System.out::print);
            System.out.println();
        }
        return nums;
    }
}
