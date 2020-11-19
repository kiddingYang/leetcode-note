package leetcode;

import common.TreeNode;

public class L108_将有序数组转换为二叉搜索树 {

    public static void main(String[] args) {

        TreeNode treeNode = new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }

    static class Solution {

        public TreeNode sortedArrayToBST(int[] nums) {
            return rootNode(nums, 0, nums.length - 1);
        }

        private TreeNode rootNode(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = (right + left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = rootNode(nums, left, mid - 1);
            root.right = rootNode(nums, mid + 1, right);
            return root;
        }
    }
}
