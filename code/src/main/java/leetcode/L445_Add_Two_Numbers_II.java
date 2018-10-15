package leetcode;

import common.ListNode;

import java.util.Stack;

/**
 * Created by Administrator on 2018/10/6.
 */
public class L445_Add_Two_Numbers_II {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;


        ListNode listNode = new Solution().addTwoNumbers(l1, l4);
        System.out.println(listNode);

    }

    static class Solution {

        /**
         * 使用了2个栈保存了两个链表,在pop出元素相加
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();

            while (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }
            ListNode tail = null;
            int carry = 0;
            while ((!s1.isEmpty()) || (!s2.isEmpty())) {
                Integer n1 = s1.isEmpty() ? 0 : s1.pop();
                Integer n2 = s2.isEmpty() ? 0 : s2.pop();
                int val = (n1 + n2 + carry) % 10;
                carry = (n1 + n2 + carry) >= 10 ? 1 : 0;
                ListNode node = new ListNode(val);
                node.next = tail;
                tail = node;
            }
            // 最后一位进位的情况
            if (carry == 1) {
                ListNode node = new ListNode(1);
                node.next = tail;
                tail = node;
            }
            return tail;
        }
    }
}
