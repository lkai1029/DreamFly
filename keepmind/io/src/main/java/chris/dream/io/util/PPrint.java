package chris.dream.io.util;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 11:40 2018-12-26
 */
public class PPrint {

    private static String format(Collection<?> collections) {
        if(collections.size() == 0) {
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");
        for(Object item : collections) {
            if(collections.size() != 1) {
                result.append("\n ");
            }
            result.append(item);
        }
        if (collections.size() != 1){
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }

    public static void print(Collection<?> c) {
        System.out.println(format(c));
    }

    public static void print(Object[] c) {
        System.out.println(Arrays.asList(c));
    }

}
