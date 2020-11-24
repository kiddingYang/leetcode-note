package leetcode;

import common.ListNode;

public class L23_合并K个升序链表 {

    public static void main(String[] args) {

    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            ListNode head = lists[0];
            for (int i = 1; i < lists.length; i++) {
                head = mergeList(head, lists[i]);
            }
            return head;
        }

        public ListNode mergeKLists2(ListNode[] lists) {
            return mergeKLists(lists, 0, lists.length - 1);
        }

        public ListNode mergeKLists(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            if (left > right) {
                return null;
            }

            int mid = (right + left) / 2;
            return mergeList(mergeKLists(lists, left, mid), mergeKLists(lists, mid + 1, right));
        }


        private ListNode mergeList(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode point = dummy;
            while (l1 != null && l2 != null) {
                ListNode newNode;
                if (l1.val <= l2.val) {
                    newNode = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    newNode = new ListNode(l2.val);
                    l2 = l2.next;
                }
                point.next = newNode;
                point = point.next;
            }
            if (l1 == null) {
                point.next = l2;
            }
            if (l2 == null) {
                point.next = l1;
            }
            return dummy.next;
        }

    }
}
