package chris.dream.jvm.init;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 5:25 2018-12-11
 */
public class InitStep {

    /**
     * 静态块可以对之后的变量进行赋值，但不能访问
     */
    static {
        i = 1;
//        System.out.println(i); // 无法访问
    }

    static int i;

    public static void main(String[] args) {
        System.out.println(i);
    }
}
