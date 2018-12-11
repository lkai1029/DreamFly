package chris.dream.jvm.oom;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 11:58 2018-12-05
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1); // true

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2); // false
    }
}
