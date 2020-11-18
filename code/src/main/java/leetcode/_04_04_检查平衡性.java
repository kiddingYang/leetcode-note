package leetcode;

import common.TreeNode;

public class _04_04_检查平衡性 {


    public static void main(String[] args) {
        new Solution().isBalanced(null);
    }


    static class Solution {

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (Math.abs(getHigh(root.left) - getHigh(root.right)) > 1) {
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }

        private int getHigh(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return Math.max(getHigh(node.left) + 1, getHigh(node.right) + 1);
        }
    }

}
