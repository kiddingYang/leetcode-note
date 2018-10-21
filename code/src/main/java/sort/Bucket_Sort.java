package sort;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/10/21.
 */
public class Bucket_Sort {


    public static void main(String[] args) {
        int[] sort = new Bucket_Sort().sort(new int[]{5, 4, 2, 1, 3, 6, 9, 10, 8, 7});
        Arrays.stream(sort).forEach(System.out::print);

    }


    private int[] sort(int[] nums) {

        List<int[]> buckets = new ArrayList<>();
        // 把数组分为2个桶
        int[] bucket1 = new int[5];
        int[] bucket2 = new int[5];
        int index1 = 0;
        int index2 = 0;
        buckets.add(bucket1);
        buckets.add(bucket2);
        for (int num : nums) {
            if(num <= 5) {
                bucket1[index1++] = num;
            } else {
                bucket2[index2++] = num;
            }
        }
        for (int[] bucket : buckets) {
            // 每个桶排序
            Arrays.sort(bucket);
        }
        int index = 0;
        for (int[] bucket : buckets) {
            for (int aBucket : bucket) {
                nums[index++] = aBucket;
            }
        }
        return nums;
    }
}
