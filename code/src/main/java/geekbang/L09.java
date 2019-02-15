package geekbang;

/**
 * 队列
 * 在课程中提到一些实现
 */
public class L09 {


}


/**
 * 使用数组实现队列
 */
class ArrayQueue {

    private int capacity;

    private int len;

    private Object[] items;

    private int head;

    private int tail;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.items = new Object[capacity];
    }


    /**
     * 入队
     */
    public boolean enqueue(Object item) {
        if (tail == len) {
            return false;
        }
        items[tail] = item;
        tail++;
        return true;
    }


    /**
     * 出队
     */
    public Object dequeue() {
        if (head == tail) {
            return null;
        }
        Object ret = items[head];
        head++;
        return ret;
    }


}
