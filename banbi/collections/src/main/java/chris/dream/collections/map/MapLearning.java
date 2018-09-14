package chris.dream.collections.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 9:59 2018-08-16
 */
public class MapLearning {
    public static void main(String[] args) {
        int h;
        int key = 32768;
        int i = (key == 0) ? 0 : (h = key) ^ (h >>> 16);
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);

        System.out.println("Hello world");
        learnHashMap();
    }

    public static void learnHashMap() {
        Map<String, String> map = new HashMap<>();

        try {
            map.putAll(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void learnHashTable() {
        Hashtable<String, String> table = new Hashtable<>();


    }
}
