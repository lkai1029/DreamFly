package chris.dream.jvm.classloader;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 12:03 2018-12-12
 */
public class AssignmentTest {
    static int x;

    public static void main(String[] args) {
        /**
         * 局部变量定义，但没有赋值，是不可以使用的。
         */
//        int a;
//        System.out.println(a); // 所以此时是会编译出错，无法加载的

        /**
         * 但是类变量会在准备阶段，赋予系统默认值
         */
        System.out.println(x);
    }
}
