import common.ListNode;


/**
 * Created by Administrator on 2018/10/3.
 */
public class L19_Remove_Nth_Node_From_End_of_List {


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
        ListNode listNode = new Solution().removeNthFromEnd2(l1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    static class Solution {

        /**
         * 第一次遍历计算需要移除的节点位置
         * 第二次遍历移除节点
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode point = new ListNode(0);
            point.next = head;
            int len = 0;
            ListNode first = head;
            while (first != null) {
                len++;
                first = first.next;
            }
            first = point;
            int removeIndex = len - n;
            while (removeIndex > 0) {
                first = first.next;
                removeIndex--;
            }
            first.next = first.next.next;
            return point.next;
        }


        /**
         * 使用快慢指针,一次遍历即可
         * 让快指针和慢指针距离差为n的距离,快指针到最后一个元素的时候,慢指针的下一个节点就是需要删除的节点
         */
        public ListNode removeNthFromEnd2(ListNode head, int n) {

            ListNode point = new ListNode(0);
            point.next = head;
            ListNode fast = point;
            ListNode slow = point;
            while (n >= 0) {
                fast = fast.next;
                n--;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return point.next;
        }
    }

}
