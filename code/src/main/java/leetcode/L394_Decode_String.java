package leetcode;

import java.util.Stack;

public class L394_Decode_String {

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("11[a]"));
    }

    static class Solution {
        public String decodeString(String s) {
            char[] chars = s.toCharArray();
            Stack<Integer> repeatTimes = new Stack<>();
            Stack<Character> characterStack = new Stack<>();
            boolean lastIsDigit = false;
            for (char aChar : chars) {
                if (Character.isDigit(aChar)) {
                    if (lastIsDigit) {
                        repeatTimes.push(repeatTimes.pop() * 10 + (aChar - '0'));
                    } else {
                        repeatTimes.push(aChar - '0');
                    }
                    lastIsDigit = true;
                } else if (aChar == ']') {
                    lastIsDigit = false;
                    Integer times = repeatTimes.pop();
                    String str = "";
                    Character pop = characterStack.pop();
                    while (pop != '[') {
                        str = pop + str;
                        pop = characterStack.pop();
                    }
                    // 循环times次
                    String string = "";
                    for (Integer i = 0; i < times; i++) {
                        string = string + str;
                    }
                    // 入栈
                    char[] charArray = string.toCharArray();
                    for (char c : charArray) {
                        characterStack.push(c);
                    }
                } else {
                    lastIsDigit = false;
                    characterStack.push(aChar);
                }
            }
            Object[] objects = characterStack.toArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (Object object : objects) {
                stringBuilder.append(object);
            }
            return stringBuilder.toString();
        }
    }
}
