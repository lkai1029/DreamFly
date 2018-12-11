package chris.dream.jvm.abs;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 5:14 2018-12-11
 */
public class AbsTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("chris.moon.jvmdemo.abs.SuperAbstract");
            SuperAbstract abs = (SuperAbstract) clazz.newInstance();
            abs.say();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
