package chris.dream.jvm.gc;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 11:50 2018-12-12
 */
public class GCVerbose {
    public static void main(String[] args) {
        byte[] memory1 = new byte[64 * 1024 * 1024];
        System.gc(); // 此时不会回收，因为memory还处于作用域之内

        {
            byte[] memory2 = new byte[64 * 1024 * 1024];
        }
        /**
         * 此时还是没有被回收，
         * 虽然已经离开了memory2的作用域，但在此之后，
         * 没有任何对局部变量表的读写操作，memory2原本咱用的Slot还没有被其他变量复用。
         */
        System.gc();

        {
            byte[] memory3 = new byte[64 * 1024 * 1024];
        }
        /**
         * 加入这段代码，有了对局部变量表的新的读写操作，复用原有Slot.
         * 可以换成 memory3 = null; 清空原先占用的Slot.
         */
        int a = 0;
        System.gc();
    }
}
