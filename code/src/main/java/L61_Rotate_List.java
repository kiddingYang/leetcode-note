import common.ListNode;

/**
 * Created by Administrator on 2018/10/7.
 */
public class L61_Rotate_List {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode listNode = new Solution().rotateRight(l1, 2);
        System.out.println(listNode);
    }


    static class Solution {

        /**
         * 使用一个数组先存储,在移动数组,最后将数组转为链表
         */
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode p = head;
            int len = 0;
            while (p != null) {
                p = p.next;
                len++;
            }
            int[] array = new int[len];
            k = k % len;
            p = head;
            int index = 0;
            while (p != null) {
                array[index] = p.val;
                index++;
                p = p.next;
            }
            for (int i = 0; i < k; i++) {
                int tmp = array[len - 1];
                for (int j = len - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = tmp;
            }
            p = head;
            for (int i : array) {
                p.val = i;
                p = p.next;
            }
            return head;
        }
    }
}
