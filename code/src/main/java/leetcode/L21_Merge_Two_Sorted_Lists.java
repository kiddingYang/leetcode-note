package leetcode;

import common.ListNode;

/**
 * Created by Administrator on 2018/10/5.
 */
public class L21_Merge_Two_Sorted_Lists {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        System.out.println(new Solution().mergeTwoLists(l1, l4));
    }

    static class Solution {

        /**
         * 使用了额外空间
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode point = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    point.next = new ListNode(l1.val);
                    l1 = l1.next;
                    point = point.next;
                } else {
                    point.next = new ListNode(l2.val);
                    l2 = l2.next;
                    point = point.next;
                }
            }
            if (l1 != null) {
                point.next = l1;
            }
            if (l2 != null) {
                point.next = l2;
            }
            return dummy.next;
        }
    }

}
