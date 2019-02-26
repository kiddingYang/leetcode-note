package geekbang;

/**
 * 二叉查找树的查找，添加，删除实现
 */
public class L24 {


    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        insert(head, 4);
        insert(head, 1);
        insert(head, 2);
        insert(head, 6);
        insert(head, 5);

//        TreeNode treeNode = find(head, 7);
//        TreeNode treeNode1 = find(head, 6);
//        TreeNode treeNode2 = find(head, 1);
//        System.out.println(treeNode + ":" + treeNode1.data + ":" + treeNode2.data);
//
//        TreeNode treeNode3 = deleteMin(head.right);
//        System.out.println(treeNode3);
//        new L23().middleOrder(head);

        new L23().middleOrder(head);
        delete_2(head, 3);
        System.out.println("-------------------");
        new L23().middleOrder(head);

    }


    /**
     * 查询
     * <p>
     * 首先，我们看如何在二叉查找树中查找一个节点。我们先取根节点，如果它等于我们要查找的数据，那就返回。
     * 如果要查找的数据比根节点的值小，那就在左子树中递归查找；如果要查找的数据比根节点的值大，那就在右子树中递归查找。
     */
    public static TreeNode find(TreeNode treeNode, Integer object) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.data == object.intValue()) {
            return treeNode;
        } else if (treeNode.data > object) {
            return find(treeNode.left, object);
        } else {
            return find(treeNode.right, object);
        }
    }


    /**
     * 插入
     * <p>
     * 如果要插入的数据比节点的数据大，并且节点的右子树为空，就将新数据直接插到右子节点的位置；如果不为空，就再递归遍历右子树，查找插入位置。
     * 同理，如果要插入的数据比节点数值小，并且节点的左子树为空，就将新数据插入到左子节点的位置；如果不为空，就再递归遍历左子树，查找插入位置。
     */
    public static void insert(TreeNode treeNode, Integer object) {
        if (treeNode == null) {
            return;
        }
        if (object > treeNode.data && treeNode.right == null) {
            treeNode.right = new TreeNode(object);
        } else if (object > treeNode.data && treeNode.right != null) {
            insert(treeNode.right, object);
        } else if (object < treeNode.data && treeNode.left == null) {
            treeNode.left = new TreeNode(object);
        } else if (object < treeNode.data && treeNode.left != null) {
            insert(treeNode.left, object);
        }
    }


    /**
     * 删除
     * 第一种情况是，如果要删除的节点没有子节点，我们只需要直接将父节点中，指向要删除节点的指针置为 null。
     * 第二种情况是，如果要删除的节点只有一个子节点（只有左子节点或者右子节点），我们只需要更新父节点中，指向要删除节点的指针，让它指向要删除节点的子节点就可以了。
     * 第三种情况是，如果要删除的节点有两个子节点，这就比较复杂了。我们需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。然后再删除掉这个最小节点，
     * 因为最小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了），所以，我们可以应用上面两条规则来删除这个最小节点。
     */
    public static void delete(TreeNode treeNode, Integer object) {
        if (treeNode == null) {
            return;
        }
        TreeNode p = treeNode;
        TreeNode pp = null;
        // 查询待删除节点和待删除节点的父节点
        while (p != null && p.data != object.intValue()) {
            pp = p;
            if (p.data > object) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        // 说明待删除的节点没找到
        if (p == null) {
            return;
        }

        if (p.left != null && p.right != null) {
            // TODO 删除节点有问题
            TreeNode deletedMin = deleteMin(p.right);
            p.data = deletedMin.data;
        } else if (p.left != null) {
            if (pp == null) {
                // 删除的是根节点
                treeNode = p.left;
            } else if (pp.left == p) {
                pp.left = p.left;
            } else {
                pp.right = p.left;
            }
        } else if (p.right != null) {
            if (pp == null) {
                treeNode = p.right;
            } else if (pp.left == p) {
                pp.left = p.right;
            } else {
                pp.right = p.right;
            }
        } else {
            if (pp == null) {
                treeNode = null;
            } else if (pp.left == p) {
                pp.left = null;
            } else {
                pp.right = null;
            }
        }
    }


    /**
     * 递归方式删除
     */
    public static void delete_1(TreeNode treeNode, Integer object) {
        if (treeNode == null) {
            return;
        } else if (treeNode.data > object) {
            delete_1(treeNode.left, object);
        } else if (treeNode.data < object) {
            delete_1(treeNode.right, object);
        } else {
            if (treeNode.left != null && treeNode.right != null) {
                TreeNode rightMin = deleteMin(treeNode.right);
                treeNode.data = rightMin.data;
//                treeNode.right =
            }
        }
    }

    /**
     * 删除一个树的最小节点
     */
    public static TreeNode deleteMin(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        TreeNode p = treeNode;
        TreeNode pp = null;
        while (p.left != null) {
            pp = p;
            p = p.left;
        }
        if (pp != null) {
            // 把当前要删除节点的右节点放入删除节点的父节点下
            pp.left = p.right;
        } else {
            // 删除的是根节点
            treeNode = treeNode.right;
        }
        return p;
    }

    static TreeNode delete_2(TreeNode root, int data) {
        TreeNode temp;
        if (root == null)
            System.out.println("要删除的元素未找到");
        else if (data < root.data)
            root.left = delete_2(root.left, data);//左子树递归删除
        else if (data > root.data)
            root.right = delete_2(root.right, data);//右子树递归删除
        else {    //找到要删除的结点
            if (root.left != null && root.right != null) { //被删除结点有左右两个子结点
                temp = deleteMin(root.right);//在右子树中找最小的元素填充删除结点
                root.data = temp.data;
                root.right = delete_2(root.right, root.data);//在删除结点的右子树中删除最小元素
            } else {   //被删除结点有一个或无子结点
                if (root.left == null)  //有右孩子或无子结点
                    root = root.right;
                else root = root.left;
            }
        }
        return root;
    }
}
