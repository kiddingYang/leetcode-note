/**
 * Created by Administrator on 2018/10/10.
 */
public class L622_Design_Circular_Queue {


    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为3

        boolean b = circularQueue.enQueue(1);// 返回true

        boolean b1 = circularQueue.enQueue(2);// 返回true

        boolean b2 = circularQueue.enQueue(3);// 返回true

        boolean b3 = circularQueue.enQueue(4);// 返回false,队列已满

        int rear = circularQueue.Rear();// 返回3

        boolean full = circularQueue.isFull();// 返回true

        boolean b4 = circularQueue.deQueue();// 返回true

        boolean b5 = circularQueue.enQueue(4);// 返回true

        int rear1 = circularQueue.Rear();// 返回4
    }

    /**
     * 注意使用数组实现,需要容量+1,
     * (tail + 1) % size == head计算是否队满
     * head == tail 计算是否为空
     */
    static class MyCircularQueue {

        private int[] queue;
        private int size;
        private int head = 0;
        private int tail = 0;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            queue = new int[k + 1];
            size = k + 1;
            head = 0;
            tail = 0;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            queue[tail] = value;
            tail = (tail + 1) % size;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % size;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[head];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return queue[(tail + size - 1) % size];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return head == tail;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return (tail + 1) % size == head;
        }
    }
}
