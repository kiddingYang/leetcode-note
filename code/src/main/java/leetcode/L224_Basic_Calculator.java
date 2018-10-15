package leetcode;

import java.util.Stack;

/**
 * Created by Administrator on 2018/10/8.
 */
public class L224_Basic_Calculator {

    public static void main(String[] args) {
        int calculate = new Solution().calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(calculate);
    }

    static class Solution {
        public int calculate(String s) {
            if (!s.contains("+") && !s.contains("-")) {
                String s1 = s.replaceAll("\\(", "")
                        .replaceAll("\\)", "")
                        .replace(" ", "");
                return Integer.valueOf(s1);
            }
            char leftParenthesis = '(';
            char rightParenthesis = ')';
            char plus = '+';
            char subtraction = '-';
            Stack<Integer> nums = new Stack<>();
            Stack<Integer> symbol = new Stack<>();
            char[] chars = s.toCharArray();
            int num = 0;
            int result = 0;
            int sign = 1;
            for (char aChar : chars) {
                if (Character.isDigit(aChar)) {
                    num = num * 10 + aChar - '0';
                } else {
                    result = num * sign + result;
                    num = 0;
                    if (aChar == plus) {
                        sign = 1;
                    } else if (aChar == subtraction) {
                        sign = -1;
                    } else if (aChar == leftParenthesis) {
                        nums.push(result);
                        symbol.push(sign);
                        result = 0;
                        sign = 1;
                    } else if (aChar == rightParenthesis && !symbol.isEmpty()) {
                        result = symbol.pop() * result + nums.pop();
                    }
                }
            }
            return result + num * sign;
        }

    }
}
