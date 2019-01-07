package chris.dream.jvm.proxy;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 8:44 2018-12-23
 */
public class TestProxy {
    public static void main(String[] args) {
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello("World!");
    }
}
