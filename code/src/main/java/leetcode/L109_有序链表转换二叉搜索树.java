package leetcode;

import common.ListNode;
import common.TreeNode;

public class L109_有序链表转换二叉搜索树 {

    public static void main(String[] args) {


    }

    static class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            return headNode(head, null);
        }

        public TreeNode headNode(ListNode left, ListNode right) {
            if (left == right) {
                return null;
            }
            ListNode midNode = getMid(left, right);
            TreeNode treeNode = new TreeNode(midNode.val);
            treeNode.left = headNode(left, midNode);
            treeNode.right = headNode(midNode.next, right);
            return treeNode;
        }

        private ListNode getMid(ListNode left, ListNode right) {
            ListNode slow = left;
            ListNode fast = left;
            while (fast != right && fast.next != right) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
