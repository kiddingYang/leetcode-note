package leetcode;

public class L121 {

    public static void main(String[] args) {


        int i = new Solution().maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(i);

    }

    static class Solution {


        /**
         * 复杂度O(n)
         */
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            int minPrice = Integer.MAX_VALUE;
            for (int price : prices) {
                if (price < minPrice) {
                    minPrice = price;
                    // 不需要计算最大收益了,因为这时候比原来最小的还小
                } else {
                    maxProfit = Math.max(maxProfit, price - minPrice);
                }
            }
            return maxProfit;
        }

        /**
         * 暴力计算O(n^2)
         */
        public int maxProfit2(int[] prices) {
            int maxProfit = 0;
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[i] >= prices[j]) {
                        continue;
                    }
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                }
            }
            return maxProfit;
        }
    }

}
