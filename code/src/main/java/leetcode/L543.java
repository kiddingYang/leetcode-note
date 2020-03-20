package leetcode;

import common.TreeNode;

public class L543 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root.left = root2;
        root.right = root3;
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root2.left = root4;
        root2.right = root5;


//        TreeNode root = new TreeNode(3);
//        TreeNode root1 = new TreeNode(1);
//        TreeNode root2 = new TreeNode(2);
//        TreeNode root3 = new TreeNode(4);
//
//        root.left = root1;
//        root1.left = root2;
//        root2.right = root3;

        int i = new Solution().diameterOfBinaryTree(root);
        System.out.println(i);
    }

    /**
     * 1
     * / \
     * 2  3
     * / \
     * 4   5
     * <p>
     * [3,1,null,2,null,null,4]
     */
    static class Solution {

        int abs = 1;

        public int diameterOfBinaryTree(TreeNode root) {
            heightOfBinaryTree(root);
            return abs - 1;
        }

        private int heightOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int left = heightOfBinaryTree(root.left);
                int right = heightOfBinaryTree(root.right);
                abs = Math.max(abs, left + right + 1);
                return Math.max(left, right) + 1;
            }
        }


        // 错误解法
//        // 遍历右节点最深加上左节点最深
//        public int diameterOfBinaryTree(TreeNode root) {
//            if (root == null) {
//                return 0;
//            }
//            // 如果使用root节点的左边深度加上右边深度,会存在不一定经过根节点的情况.
//            return heightOfBinaryTree(root.left) + heightOfBinaryTree(root.right);
//        }
//
//        private int heightOfBinaryTree(TreeNode root) {
//            if (root == null) {
//                return 0;
//            } else {
//                int left = heightOfBinaryTree(root.left);
//                int right = heightOfBinaryTree(root.right) ;
//                return left > right ? left + 1 : right + 1;
//            }
//        }


    }

}
