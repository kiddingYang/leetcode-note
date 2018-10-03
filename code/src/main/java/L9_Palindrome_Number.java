/**
 * Created by Administrator on 2018/10/3.
 */
public class L9_Palindrome_Number {

    public static void main(String[] args) {
        boolean palindrome = new Solution().isPalindrome(12521);
        System.out.println(palindrome);
    }

}

class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String XString = String.valueOf(x);
        char[] chars = XString.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
