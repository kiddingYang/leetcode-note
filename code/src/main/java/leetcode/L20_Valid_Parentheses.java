package leetcode;

import java.util.Stack;

public class L20_Valid_Parentheses {


    public static void main(String[] args) {
        System.out.println(new Solution().isValid(")"));
    }


    static class Solution {
        public boolean isValid(String s) {
            char[] chars = s.toCharArray();
            // '(',')' '{', '}', '[' ']'
            char leftParenthesis = '(';
            char rightParenthesis = ')';
            char leftBracket = '[';
            char rightBracket = ']';
            char leftBrace = '{';
            char rightBrace = '}';

            Stack<Character> stack = new Stack<>();
            for (char ch : chars) {
                if (ch == leftParenthesis || ch == leftBracket || ch == leftBrace) {
                    stack.push(ch);
                } else if (ch == rightBrace) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    if (pop != leftBrace) {
                        return false;
                    }
                } else if (ch == rightBracket) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    if (pop != leftBracket) {
                        return false;
                    }
                } else if (ch == rightParenthesis) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    if (pop != leftParenthesis) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
