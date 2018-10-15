package leetcode;

import common.ListNode;

/**
 * Created by Administrator on 2018/10/6.
 */
public class L237_Delete_Node_in_a_Linked_List {


    public static void main(String[] args) {


    }


    static class Solution {

        /**
         *
         * 把当前节点值和后一个节点值交换,在删除后一个节点的值
         */
        public void deleteNode(ListNode node) {
            if (node == null) {
                return;
            }
            // 当前节点和后一天节点交换
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
        }
    }
}
