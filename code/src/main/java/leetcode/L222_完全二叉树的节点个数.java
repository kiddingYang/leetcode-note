package leetcode;

import common.TreeNode;

public class L222_完全二叉树的节点个数 {

    public static void main(String[] args) {


    }

    static class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + countNodes(root.right) + countNodes(root.left);
        }
    }

}
