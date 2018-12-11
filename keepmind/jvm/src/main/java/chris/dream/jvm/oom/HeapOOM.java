package chris.dream.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris
 * @description: <p>堆溢出</p>
 * @date 上午 11:32 2018-12-05
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
