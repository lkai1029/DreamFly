package chris.dream.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 10:48 2018-08-16
 */
public class SetLearning {

    public static void main(String[] args) {
        learnHashSet();
    }

    public static void learnHashSet() {
        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");

        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }

        System.out.println(set);
    }
}
