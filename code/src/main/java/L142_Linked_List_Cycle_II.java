import common.ListNode;

/**
 * Created by Administrator on 2018/10/4.
 */
public class L142_Linked_List_Cycle_II {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
//        l2.next = null;
        l2.next = l3;
        l3.next = l2;
        System.out.println(new L142_Linked_List_Cycle_II.Solution().detectCycle(l1));
    }

    static class Solution {

        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return null;
                }
                slow = slow.next;
                fast = fast.next.next;
            }

            // 查找循环链表头节点 推导参考 https://www.jianshu.com/p/ce7f035daf74
            slow = head;
            fast = fast.next;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}
