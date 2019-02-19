package geekbang;


import java.util.Objects;

public class L18 {


    public static void main(String[] args) {
        IHashMap iHashMap = new IHashMap(10);
        iHashMap.put("a", "a");
        iHashMap.put("casdas", 2);
        iHashMap.put(3, 3);
        iHashMap.put(4, 4);
        iHashMap.put(5, 5);
        System.out.println(iHashMap.get("a"));
        System.out.println(iHashMap.get("casdas"));
        System.out.println(iHashMap.get(3));
        System.out.println(iHashMap.get(4));
        System.out.println(iHashMap.get(5));
        System.out.println(iHashMap.get("c"));
        System.out.println(iHashMap.get(7));
    }

}

/**
 * 实现一个简单的hashMap,不支持扩容,仅仅了解原理
 */
class IHashMap {

    private Node[] items;

    private int len;

    public IHashMap(int len) {
        this.items = new Node[len];
    }

    public Object get(Object key) {
        Node item = items[indexFor(hash(key), items.length)];
        if (item != null) {
            if (item.getKey().equals(key)) {
                return item.getVal();
            }
            Node next = item.getNext();
            while (next != null) {
                if (next.getKey().equals(key)) {
                    return next.getVal();
                }
                next = next.getNext();
            }
        }
        return null;
    }

    public Object put(Object key, Object value) {
        if (len >= items.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int index = indexFor(hash(key), items.length);
        Node newNode = new Node(value, key, hash(key), null);
        Node node = items[index];
        if (node == null) {
            items[index] = newNode;
        } else {
            // 查询到最后一个链表
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(newNode);
        }
        len++;
        return null;
    }

    static class Node {
        private Object val;
        private Object key;
        private final int hash;
        Node next;

        public Node(Object val, Object key, int hash, Node next) {
            this.val = val;
            this.key = key;
            this.hash = hash;
            this.next = next;
        }

        public Object getVal() {
            return val;
        }

        public void setVal(Object val) {
            this.val = val;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public int getHash() {
            return hash;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
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