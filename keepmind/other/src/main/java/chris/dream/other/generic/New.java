package chris.dream.other.generic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 6:52 2019-01-29
 */
public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    public static <T> Set<T> unicom(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    public static void main(String[] args) {
        Map<String, String> map = New.<String, String>map();

        New.<String>unicom(new HashSet<>(), new HashSet<>());
    }
}
