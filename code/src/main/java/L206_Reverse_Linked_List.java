import common.ListNode;

/**
 * Created by Administrator on 2018/10/5.
 */
public class L206_Reverse_Linked_List {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode listNode = new Solution().reverseList(l1);
        System.out.println(listNode);
    }

    static class Solution {
        /**
         * 迭代方式翻转
         */
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode reverseHead = new ListNode(head.val);
            ListNode point = head.next;
            while (point != null) {
                ListNode node = new ListNode(point.val);
                // 每次插入链表头部
                node.next = reverseHead;
                reverseHead = node;
                point = point.next;
            }
            return reverseHead;
        }
    }
}
