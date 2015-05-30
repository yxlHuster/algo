package LeetCode;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-5-30
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
class RandomListNode {
    public RandomListNode random;
    public RandomListNode next;
    public int val;
    public RandomListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class RandomListCopy {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode p = head;
        while (p.next != null) {
            RandomListNode copy = new RandomListNode(p.val);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        p = head;
        while (p.next != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        RandomListNode copyHead = head.next;
        p = head;
        while (p.next != null) {
            RandomListNode temp = p.next;
            p.next = temp.next;
            if (temp.next != null) temp.next = temp.next.next;
            p = p.next;
        }
        return copyHead;
    }


    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) return null;

        RandomListNode newHead = new RandomListNode(head.val);

        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
        nodeMap.put(head, newHead);

        RandomListNode q = newHead;
        RandomListNode p = head;
        p = p.next;
        while (p != null) {
            RandomListNode temp = new RandomListNode(p.val);
            nodeMap.put(p, temp);
            q.next = temp;
            q = q.next;
            p = p.next;
        }

        p = head;
        q = newHead;
        while (p != null) {
            if (p.random != null) {
                q.random = nodeMap.get(p.random);
            } else {
                q.random = null;
            }
            p = p.next;
            q = q.next;
        }
        return newHead;

    }
}
