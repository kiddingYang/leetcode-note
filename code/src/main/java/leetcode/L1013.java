package leetcode;

public class L1013 {


    public static void main(String[] args) {

        boolean b = new Solution().canThreePartsEqualSum(new int[]{1,-1,-1,1});
        System.out.println(b);

    }


    static class Solution {

        public boolean canThreePartsEqualSum(int[] A) {
            int sum = 0;
            for (int i : A) {
                sum += i;
            }
            if (sum % 3 != 0) {
                return false;
            }
            int val = sum / 3;
            int left = 0;
            int right = A.length - 1;
            int leftSum = A[left];
            int rightSum = A[right];

            while (left < right - 1) {
                if (leftSum == val && rightSum == val) {
                    return true;
                }
                if (leftSum != val) {
                    leftSum += A[++left];
                }
                if (rightSum != val) {
                    rightSum += A[--right];
                }
            }
            return false;
        }
    }

}
