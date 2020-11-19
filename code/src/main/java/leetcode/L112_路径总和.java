package leetcode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class L112_路径总和 {

    public static void main(String[] args) {

    }

    static class Solution {

        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return root.val == sum;
            }

            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }

        public boolean hasPathSum2(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            Queue<Integer> valQueue = new LinkedList<>();
            nodeQueue.offer(root);
            valQueue.offer(root.val);

            while (!nodeQueue.isEmpty()) {
                TreeNode treeNode = nodeQueue.poll();
                Integer nodeVal = valQueue.poll();
                if (treeNode.left == null && treeNode.right == null) {
                    if (nodeVal == sum) {
                        return true;
                    }
                    continue;
                }
                if (treeNode.left != null) {
                    nodeQueue.offer(treeNode.left);
                    valQueue.offer(treeNode.left.val + nodeVal);
                }
                if (treeNode.right != null) {
                    nodeQueue.offer(treeNode.right);
                    valQueue.offer(treeNode.right.val + nodeVal);
                }
            }
            return false;
        }

    }
}
