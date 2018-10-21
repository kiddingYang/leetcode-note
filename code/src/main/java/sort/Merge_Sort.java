package sort;


/**
 * Created by Administrator on 2018/10/21.
 */
public class Merge_Sort {


    public static void main(String[] args) {

        int[] nums = new int[]{4, 5, 2, 1, 6, 3};
        new Merge_Sort().sort(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }

    }

    private void sort(int[] nums) {
        int[] tmp = new int[nums.length];
        sort(nums, 0, nums.length - 1, tmp);
    }


    private void sort(int[] nums, int left, int right, int[] tmp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        // 排序左边
        sort(nums, left, mid, tmp);
        // 排序右边
        sort(nums, mid + 1, right, tmp);
        // 合并数组
        mergeArray(nums, left, mid, right, tmp);
    }

    private void mergeArray(int[] nums, int left, int mid, int right, int[] tmp) {

        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[index++] = nums[i++];
            } else {
                tmp[index++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[index++] = nums[i++];
        }
        while (j <= right) {
            tmp[index++] = nums[j++];
        }

        // 把临时数组的值赋值给原数组
        for (i = 0; i < index; i++) {
            nums[left + i] = tmp[i];
        }
    }

}
