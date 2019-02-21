package geekbang;

import java.util.Objects;

/**
 * 链表和hash表一起使用
 * LRU算法实现(O(1))
 */
public class L20 {


}

class Lru {

    private int len;
    private Node[] items;
    private Node head;
    private Node tail;

    public Lru(int len) {
        this.items = new Node[len];
        this.head = new Node(null, null, null, null, -1);
        this.tail = new Node(null, null, null, null, -1);
        head.setNext(tail);
        tail.setPre(head);
    }


    public Node findData(int data) {
        int hash = hash(data);
        int index = indexFor(hash, items.length);
        Node node = items[index];
        if (node != null) {
            if (node.getData() == data) {
                setToHead(node);
                return node;
            }
            Node next = node.getNext();
            while (next != null) {
                if (node.getData() == data) {
                    setToHead(node);
                    return node;
                }
                next = next.getNext();
            }
        }
        return null;
    }

    private void setToHead(Node node) {
        Node pre = node.getPre();
        Node next = node.getNext();
        Node prePre = pre.getPre();
        pre.setNext(next);
        pre.setPre(node);
        next.setPre(pre);
        node.setPre(prePre);
        if (prePre != null) {
            prePre.setNext(node);
        }
    }


    public void removeData(int data) {

    }

    public void insertData(int data) {
        Node findData = findData(data);
        if (findData == null) {
            // 需要删除最后一个节点
            if (len == items.length) {
                int index = indexFor(hash(data), items.length);
                Node newNode = new Node(data, hash(data));
                Node item = items[index];
                if (item == null) {
                    items[index] = newNode;
                    newNode.setPre(head);
                    newNode.setNext(head.next);
                    head.getNext().setPre(newNode);
                }
            } else {


            }
        }
    }


    static class Node {
        private Node pre;
        private Node next;
        private Integer data;
        private Node hNext;
        private int hash;

        public Node(Node pre, Node next, Integer data, Node hNext, int hash) {
            this.pre = pre;
            this.next = next;
            this.data = data;
            this.hNext = hNext;
            this.hash = hash;
        }

        public Node(Integer data, int hash) {
            this.data = data;
            this.hash = hash;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node gethNext() {
            return hNext;
        }

        public void sethNext(Node hNext) {
            this.hNext = hNext;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }
    }

    /**
     * 简单的hash算法
     */
    final int hash(Object k) {
        return Objects.hash(k);
    }

    /**
     * 计算该hash值所在数组的index
     */
    static int indexFor(int h, int length) {
        return h & (length - 1);
    }

}