package leetcode;

import java.util.Stack;

/**
 * Created by Administrator on 2018/10/11.
 */
public class L232_Implement_Queue_using_Stacks {
    public static void main(String[] args) {


    }

    static class MyQueue {

        private Stack<Integer> stack;
        private Stack<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack<>();
            queue = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
            Integer pop = queue.pop();
            while (!queue.isEmpty()) {
                stack.push(queue.pop());
            }
            return pop;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
            Integer peek = queue.peek();
            while (!queue.isEmpty()) {
                stack.push(queue.pop());
            }
            return peek;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
