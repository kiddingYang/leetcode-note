package leetcode;

/**
 * Created by Administrator on 2018/10/7.
 */
public class L7_Reverse_Integer {

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
    }


    static class Solution {

        /**
         *  将每一位存储在数组中并且计算长度,在计算没一位的权重,数字乘以权重相加
         *  注意翻转后可能会出现越界的情况,所以使用long存储
         */
        public int reverse(int x) {
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            boolean negative = false;
            if (x < 0) {
                negative = true;
                x = -x;
            }

            char[] chars = Integer.valueOf(x).toString().toCharArray();
            int[] nums = new int[chars.length];
            boolean flag = true;
            int index = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                if (flag) {
                    if (chars[i] - 48 != 0) {
                        flag = false;
                        nums[index] = chars[i] - 48;
                        index++;
                    }
                } else {
                    nums[index] = chars[i] - 48;
                    index++;
                }
            }
            long reverseNum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (index > 0) {
                    long weight = 1;
                    for (int j = 0; j < index - 1; j++) {
                        weight = weight * 10;
                    }
                    index--;
                    reverseNum = reverseNum + weight * nums[i];
                } else {
                    break;
                }
            }
            if (reverseNum > Integer.MAX_VALUE) {
                return 0;
            }
            if (negative) {
                reverseNum = -reverseNum;
            }
            return (int) reverseNum;
        }
    }
}
