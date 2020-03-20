package common;

public class KthLargest {

    private TreeNode root;
    private int k;

    public KthLargest(int k, int[] nums) {
        TreeNode head = null;
        for (int num : nums) {
            head = insertIntoBST(null, num);
        }
        this.root = head;
        this.k = k;
    }

    public int add(int val) {
        int k = getK(root, this.k);
        this.k = val;
        insertIntoBST(root, val);
        return k;
    }

    private int getK(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int k1 = getK(root.left, k);
        if (k1 != -1) {
            return k1;
        }
        if (k > 0) {
            k--;
        } else {
            return root.val;
        }
        int k2 = getK(root.right, k);
        if (k2 != -1) {
            return k2;
        }
        return -1;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val && root.right == null) {
            root.right = new TreeNode(val);
        } else if (val > root.val && root.right != null) {
            insertIntoBST(root.right, val);
        } else if (val < root.val && root.left == null) {
            root.left = new TreeNode(val);
        } else if (val < root.val && root.left != null) {
            insertIntoBST(root.left, val);
        }
        return root;
    }


    static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
