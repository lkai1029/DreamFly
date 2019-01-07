package chris.dream.jvm;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 6:17 2019-01-05
 */
public class ReviewTest {
    public static void main(String[] args) {
        ClassLoader classLoader = Object.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader1 = ReviewTest.class.getClassLoader();
        System.out.println(classLoader1);

        System.out.println(ClassLoader.getSystemClassLoader());
        Thread.currentThread().getContextClassLoader();
    }
}
