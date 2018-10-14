import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/14.
 */
public class L144_Binary_Tree_Preorder_Traversal {


    public static void main(String[] args) {

    }


    static class Solution {

        private List<Integer> vals = new ArrayList<>();

        /**
         * 递归实现
         */
        public List<Integer> preorderTraversal(TreeNode root) {

            if (root == null) {
                return vals;
            }
            vals.add(root.val);
            TreeNode left = root.left;
            if (left != null) {
                preorderTraversal(left);
            }
            TreeNode right = root.right;
            if (right != null) {
                preorderTraversal(right);
            }
            return vals;
        }
    }

}
