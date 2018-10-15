package sort;


import java.util.Arrays;

/**
 * 冒泡排序
 * 依次比较两个相邻的元素，如果他们的顺序（如从大到小、首字母从A到Z）错误就把他们交换过来
 * Created by Administrator on 2018/10/15.
 */
public class Bubble_Sort {

    public static void main(String[] args) {
        int[] sort = new Bubble_Sort().sort(new int[]{5, 4, 2, 1, 3});
        Arrays.stream(sort).forEach(System.out::print);
    }


    private int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
            Arrays.stream(nums).forEach(System.out::print);
            System.out.println();
        }
        return nums;
    }

}
