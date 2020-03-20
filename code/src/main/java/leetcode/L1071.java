package leetcode;

public class L1071 {

    public static void main(String[] args) {
        final String s = new Solution().gcdOfStrings("LEET", "CODE");
        System.out.println(s);
    }

    static class Solution {

        /**
         * 暴力解法;优化算法可以查看GCD
         */
        public String gcdOfStrings(String str1, String str2) {
            if (str1 == null || str2 == null) {
                return "";
            }
            String maxString = "";
            String minString = str1.length() > str2.length() ? str2 : str1;
            for (int i = 0; i < minString.length(); i++) {
                String tmp = minString.substring(0, i + 1);
                if (match(str1, tmp) && match(str2, tmp)) {
                    maxString = tmp;
                }
            }
            return maxString;
        }

        public boolean match(String str1, String str2) {
            if (str1.length() < str2.length()) {
                return false;
            }
            if (str1.length() % str2.length() != 0) {
                return false;
            }
            for (int i = 0; i < str1.length(); i++) {
                if (str2.charAt(i % str2.length()) != str1.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

    }
}
