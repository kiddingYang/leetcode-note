package leetcode;

import common.TreeNode;

/**
 * Created by Administrator on 2018/10/24.
 */
public class L230_Kth_Smallest_Element_in_a_BST {

    public static void main(String[] args) {

    }

    /**
     * 中序遍历二叉树,第k个值就是第K小
     */
    static class Solution {
        int count = 0;
        int val = 0;

        public int kthSmallest(TreeNode root, int k) {
            dfs(root, k);
            return val;
        }

        private void dfs(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            dfs(root.left, k);
            count++;
            if (count == k) {
                this.val = root.val;
            }
            dfs(root.right, k);
        }
    }
}
