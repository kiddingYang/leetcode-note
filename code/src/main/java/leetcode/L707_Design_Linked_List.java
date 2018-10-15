package leetcode;

/**
 * Created by Administrator on 2018/10/13.
 */
public class L707_Design_Linked_List {


    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
        l.addAtHead(1);
        l.addAtIndex(1,2);
        l.get(1);
        l.get(0);
        l.get(2);
    }

    static class MyLinkedList {

        private int[] array;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            array = new int[]{-1, -1};
            size = 0;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index >= size) {
                return -1;
            }
            return array[index];
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            if (size == array.length) {
                int[] copyArray = new int[size * 10];
                System.arraycopy(array, 0, copyArray, 1, size);
                array = copyArray;
            } else {
                System.arraycopy(array, 0, array, 1, size);
            }
            size++;
            array[0] = val;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            if (size == array.length) {
                int[] copyArray = new int[size * 10];
                System.arraycopy(array, 0, copyArray, 0, size);
                array = copyArray;
            }
            array[size] = val;
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            if (size == array.length) {
                int[] copyArray = new int[size * 10];
                System.arraycopy(array, 0, copyArray, 0, size);
                array = copyArray;
            }
            System.arraycopy(array, index, array, index + 1, size - index);
            size++;
            array[index] = val;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }
            int numMoved = size - index - 1;
            if (numMoved > 0)
                System.arraycopy(array, index + 1, array, index,
                        numMoved);
            size--;
        }
    }
}
