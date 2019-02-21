package geekbang;

/**
 * 二叉树基础
 */
public class L23 {

    public static void main(String[] args) {
        TreeNode ta = new TreeNode("a");
        TreeNode tb = new TreeNode("b");
        TreeNode tc = new TreeNode("c");
        TreeNode td = new TreeNode("d");
        TreeNode te = new TreeNode("e");
        TreeNode tf = new TreeNode("f");

        ta.left = tb;
        tb.right = tc;
        tb.left = td;
        tb.right = te;
        te.left = tf;

        new L23().preOrder(ta);
        System.out.println("--------------");
        new L23().middleOrder(ta);
        System.out.println("--------------");
        new L23().postOrder(ta);

    }


    /**
     * 先序遍历
     * 当前节点 -> 左子树 -> 右子树
     */
    public void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.data);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    /**
     * 中序遍历
     * 左子树 ----》 当前节点 ----》 右子树
     */
    public void middleOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        middleOrder(treeNode.left);
        System.out.println(treeNode.data);
        middleOrder(treeNode.right);
    }

    /**
     * 后序遍历
     * 左子树 ----》 右子树 ---》 当前节点
     */
    public void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.println(treeNode.data);
    }

}

class TreeNode {

    TreeNode left;

    TreeNode right;

    Object data;

    public TreeNode(Object data) {
        this.data = data;
    }
}
