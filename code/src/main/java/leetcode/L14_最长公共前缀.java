package leetcode;


public class L14_最长公共前缀 {

    public static void main(String[] args) {
        String[] strings = new String[]{"flower", "flow", "flight"};
        String s = new Solution().longestCommonPrefix(strings);
        System.out.println(s);
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }

        public String longestCommonPrefix(String[] strs, int left, int right) {
            if (left > right) {
                return "";
            }
            if (left == right) {
                return strs[left];
            }
            int mid = (left + right) / 2;
            return longestCommonPrefix(longestCommonPrefix(strs, left, mid), longestCommonPrefix(strs, mid + 1, right));
        }

        public String longestCommonPrefix(String str1, String str2) {
            char[] charArray = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();
            int len = Math.min(charArray.length, charArray2.length);
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = 0; i < len; i++) {
                if (charArray[i] == charArray2[i]) {
                    stringBuilder.append(charArray[i]);
                } else {
                    return stringBuilder.toString();
                }
            }
            return stringBuilder.toString();
        }
    }
}
