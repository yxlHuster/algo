package concurrent.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: hotallen
 * Date: 2016/6/2
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
public class LruDelegation<K, V> {

    private final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;

    private LinkedHashMap<K, V> delegator;

    public LruDelegation(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        delegator =  new LinkedHashMap<K, V>((int) Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTOR) + 1, DEFAULT_LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    public synchronized void put(K key, V value) {
        delegator.put(key, value);
    }

    public synchronized V get(K key) {
        return delegator.get(key);
    }

    public synchronized V remove(K key) {
        return delegator.remove(key);
    }

    public synchronized int size() {
        return delegator.size();
    }

    public synchronized void clear() {
        delegator.clear();
    }

    public synchronized Set<Map.Entry<K, V>> getAll() {
        return delegator.entrySet();
    }
}
