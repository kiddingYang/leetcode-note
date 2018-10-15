package sort;

import java.util.Arrays;

/**
 * 插入排序
 * 所谓插入排序法，就是检查第i个数字，如果在它的左边的数字比它大，
 * 进行交换，这个动作一直继续下去，直到这个数字的左边数字比它还要小，就可以停止了。
 * 插入排序法主要的回圈有两个变数：i和j，每一次执行这个回圈，就会将第i个数字放到左边恰当的位置去。
 * Created by Administrator on 2018/10/15.
 */
public class Insertion_Sort {

    public static void main(String[] args) {
        new Insertion_Sort().sort(new int[]{5, 4, 2, 1, 3});
    }


    private int[] sort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                } else {
                    break;
                }
            }
            Arrays.stream(nums).forEach(System.out::print);
            System.out.println();
        }
        return nums;
    }
}
