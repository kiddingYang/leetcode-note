package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L_M_40 {

    public static void main(String[] args) {

        int[] leastNumbers = new Solution().getLeastNumbers(new int[]{}, 1);
        Arrays.stream(leastNumbers).forEach(System.out::print);

    }

    static class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k >= arr.length) {
                return arr;
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i : arr) {
                queue.add(i);
            }
            int[] array = new int[k];
            for (int i = 0; i < k; i++) {
                array[i] = queue.poll();
            }
            return array;
        }
    }
}
