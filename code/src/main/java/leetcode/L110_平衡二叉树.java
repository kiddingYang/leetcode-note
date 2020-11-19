package leetcode;

import common.TreeNode;

public class L110_平衡二叉树 {

    public static void main(String[] args) {


    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return Math.abs(getHight(root.left) - getHight(root.right)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
        }

        private int getHight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(getHight(root.left), getHight(root.right)) + 1;
        }
    }

}
