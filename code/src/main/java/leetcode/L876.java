package leetcode;

import common.ListNode;

public class L876 {

    public static void main(String[] args) {


    }


    static class Solution {
        /**
         * 暴力解法
         */
        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return null;
            }
            int len = 0;
            ListNode point = head;
            while (point != null) {
                point = point.next;
                len++;
            }
            int middle = len / 2;
            while (middle-- > 0) {
                head = head.next;
            }
            return head;
        }


        /**
         * 快慢指针
         */
        public ListNode middleNode2(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast.next != null) {
                return slow.next;
            }
            return slow;
        }
    }
}
