import common.ListNode;

/**
 * Created by Administrator on 2018/10/3.
 * 结题思路: 翻转链表存储,在比较翻转链表和原来链表每个节点的值
 */
public class L234_Palindrome_Linked_List {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        boolean palindrome = new Solution().isPalindrome(l1);
        System.out.println(palindrome);
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {

            if (head == null) {
                return true;
            }
            ListNode point = head;
            ListNode tail = new ListNode(head.val);
            while (point.next != null) {
                int nextVal = point.next.val;
                point = point.next;
                ListNode pre = new ListNode(nextVal);
                pre.next = tail;
                tail = pre;
            }
            while (head != null) {
                if (head.val != tail.val) {
                    return false;
                }
                head = head.next;
                tail = tail.next;
            }
            return true;
        }
    }
}
