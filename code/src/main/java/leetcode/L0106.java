package leetcode;

public class L0106 {

    public static void main(String[] args) {

        final String string = new Solution().compressString("aabcccccaaa");
        System.out.println(string);

    }

    static class Solution {
        public String compressString(String S) {
            final char[] array = S.toCharArray();
            int count = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < array.length; i++) {
                if (array[i] == array[i - 1]) {
                    count++;
                } else {
                    stringBuilder.append(array[i]).append(count);
                    count = 1;
                }
            }
            stringBuilder.append(array[array.length -1]).append(count);
            return stringBuilder.length() < S.length() ? stringBuilder.toString() : S;
        }
    }
}
