package geekbang;

/**
 * 堆
 */
public class L25 {


    public static void main(String[] args) {



    }

}

/**
 * 存储堆中的值,从下标1开始存储,这样就可以使用完全二叉树的特征
 * 数组中下标为 i 的节点的左子节点,就是下标为 i∗2 的节点,
 * 右子节点就是下标为 i∗2+1 的节点,父节点就是下标为 i/2 的节点
 */
class Heap {


    static int[] items;
    // 能够存储的最大个数
    private static int max;
    // 当前存储的个数
    private static int count;

    public Heap(int size) {
        items = new int[size + 1];
        max = size;
    }

    /**
     * 堆化
     */
    public static void insert(int data) {
        if (count >= max) {
            return;
        }
        count++;
        items[count] = data;
        // 调整堆
        int i = count;
        while (i / 2 > 0 && items[i] > items[i / 2]) {
            // 交换父子节点值
            int item = items[i];
            int pItem = items[i / 2];
            items[i] = pItem;
            items[i / 2] = item;
            i = i / 2;
        }
    }



}