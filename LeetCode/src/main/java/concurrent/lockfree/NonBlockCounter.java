package concurrent.lockfree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: hotallen
 * Date: 2016/6/2
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
 */
public class NonBlockCounter {

    private AtomicInteger atomicInteger;

    public int incrementAndGet() {
        int value;
        do {
            value = atomicInteger.get();
        } while (!atomicInteger.compareAndSet(value, value + 1));
        return value + 1;
    }
}
