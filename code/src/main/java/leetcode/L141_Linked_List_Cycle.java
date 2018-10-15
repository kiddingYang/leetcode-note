package leetcode;

import common.ListNode;


/**
 * Created by Administrator on 2018/10/4.
 */
public class L141_Linked_List_Cycle {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = null;
//        l2.next = l3;
//        l3.next = l2;
        System.out.println(new Solution().hasCycle(l1));
    }

    static public class Solution {

        /**
         *  如果快指针追击到慢指针那么就是循环链表,
         *  如果快指针先走完那么就不是循环链表
         */
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != slow) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
}
