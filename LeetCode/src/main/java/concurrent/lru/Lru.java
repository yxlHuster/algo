package concurrent.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: hotallen
 * Date: 2016/6/2
 * Time: 16:28
 * To change this template use File | Settings | File Templates.
 */
public class Lru<K, V> extends LinkedHashMap<K, V> {

    private final int MAX_SIZE;

    public Lru(int max) {
        super((int) Math.ceil(max / 0.75), 0.75f, true);
        MAX_SIZE = max;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return MAX_SIZE < size();
    }

}
