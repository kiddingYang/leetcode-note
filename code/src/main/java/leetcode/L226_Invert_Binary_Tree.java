package leetcode;

import common.TreeNode;

/**
 * Created by Administrator on 2018/10/14.
 */
public class L226_Invert_Binary_Tree {


    static class Solution {

        /**
         * 从上往下遍历,
         * 也可以从下往上遍历---未实现
         */
        public TreeNode invertTree(TreeNode root) {

            if (root == null) {
                return null;
            }
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
            invertTree(root.left);
            invertTree(root.right);

            return root;
        }
    }
}
