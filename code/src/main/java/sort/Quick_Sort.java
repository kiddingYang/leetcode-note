package sort;



/**
 * Created by Administrator on 2018/10/21.
 */
public class Quick_Sort {


    public static void main(String[] args) {

        int[] nums = new int[]{4, 5, 2, 1, 6, 3};
        new Quick_Sort().sort(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }

    }

    private void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int tmp = nums[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (i < j && nums[j] >= tmp) {
                j--;
            }
            while (i < j && nums[i] <= tmp) {
                i++;
            }
            // 找到两个需要交换的哨兵
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        // 将最左边的值和哨兵相遇的值交换
        nums[left] = nums[i];
        nums[i] = tmp;
        // 比较左边的数组
        sort(nums, left, i - 1);
        // 比较右边的数组
        sort(nums, i + 1, right);

    }


}
