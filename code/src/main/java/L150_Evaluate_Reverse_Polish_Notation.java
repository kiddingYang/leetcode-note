import java.util.Stack;

/**
 * Created by Administrator on 2018/10/9.
 */
public class L150_Evaluate_Reverse_Polish_Notation {

    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> nums = new Stack<>();
            for (String token : tokens) {
                if (token.equals("+")) {
                    nums.push(nums.pop() + nums.pop());
                } else if (token.equals("-")) {
                    nums.push(-nums.pop() + nums.pop());
                } else if (token.equals("*")) {
                    nums.push(nums.pop() * nums.pop());
                } else if (token.equals("/")) {
                    Integer num1 = nums.pop();
                    Integer num2 = nums.pop();
                    nums.push(num2 / num1);
                } else {
                    nums.push(Integer.valueOf(token));
                }
            }
            return nums.pop();
        }
    }
}
