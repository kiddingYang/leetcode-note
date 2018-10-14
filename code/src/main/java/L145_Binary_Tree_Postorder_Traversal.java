import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/14.
 */
public class L145_Binary_Tree_Postorder_Traversal {


    static class Solution {

        private List<Integer> vals = new ArrayList<>();

        /**
         * 递归算法
         */
        public List<Integer> postorderTraversal(TreeNode root) {

            if (root == null) {
                return vals;
            }
            TreeNode left = root.left;
            postorderTraversal(left);
            TreeNode right = root.right;
            postorderTraversal(right);
            vals.add(root.val);
            return vals;
        }
    }
}
