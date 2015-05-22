package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-3-9
 * Time: 下午8:17
 * To change this template use File | Settings | File Templates.
 */
public class LRUCache {

    private Map<Integer, Node> mps;
    private Node head;
    private Node tail;
    private int size;

    public LRUCache(int capacity) {
        mps = new HashMap<Integer, Node>(capacity);
        head = new Node(1, 1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        size = capacity;
    }

    public int get(int key) {
        if (mps.containsKey(key)) {
            Node node = mps.get(key);
            put2Head(node);
            return node.value;
        }
        return -1;
    }



    public void set(int key, int value) {
        if (mps.containsKey(key)) {
            Node node = mps.get(key);
            node.value = value;
            put2Head(node);
        } else {
            if (mps.size() < size) {
                Node node = new Node(key, value);
                mps.put(key, node);
                put2Head(node);
            } else {
                Node node = new Node(key, value);
                mps.put(key, node);
                put2Head(node);
                int oldKey = removeOld();
                mps.remove(oldKey);
            }
        }
    }

    private void put2Head(Node node) {
        if (node.pre != null && node.next != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;

    }

    private int removeOld() {
        Node node = tail.pre;
        node.pre.next = tail;
        tail.pre = node.pre;
        node.pre = null;
        node.next = null;
        return node.key;
    }

	class Node {
		public Node pre;
        public Node next;
		public int key;
		public int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
	}
}
