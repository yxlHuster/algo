package concurrent.lockfree;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 * User: hotallen
 * Date: 2016/6/2
 * https://www.ibm.com/developerworks/library/j-jtp04186/
 * Time: 13:17
 * To change this template use File | Settings | File Templates.
 */
public class NonBlockList<E> {


    private AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(new Node<E>(null, null));
    private AtomicReference<Node<E>> tail = head;


    public boolean put(E item) {
        Node<E> newNode = new Node<E>(item, null);
        while (true) {
            Node<E> currentTail = tail.get();
            Node<E> residue = currentTail.next.get();
            if (currentTail == tail.get()) {
                if (residue == null) {
                    if (currentTail.next.compareAndSet(null, newNode)) {
                        tail.compareAndSet(currentTail, newNode);
                        return true;
                    }
                } else {
                    tail.compareAndSet(currentTail, residue);
                }
            }
        }
    }


    static class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<Node<E>>(next);
        }
    }



}
