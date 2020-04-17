package leetcode;

public class L5 {


    public static void main(String[] args) {


    }


    static class Solution {

        // 状态转移公式dp[i,j] = s[i] + dp[i-1,j-1] + s[j] && s[i] == s[j]
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            String result = "";
            for (int i = 0; i < chars.length; i++) {
                String dp = dp(i, s);
                if (result.length() > dp.length()) {
                    result = dp;
                }
            }
            return result;
        }


        private String dp(int index, String s) {
            if (index == 0) {
                return s.charAt(0) + "";
            }
            if (index == 1) {
                if (s.charAt(0) == s.charAt(1)) {
                    return s;
                }
                return s.charAt(0) + "";
            }


            return "";
        }
    }

}
