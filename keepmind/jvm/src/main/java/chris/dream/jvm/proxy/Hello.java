package chris.dream.jvm.proxy;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 8:43 2018-12-23
 */
public class Hello implements IHello {
    @Override
    public void sayHello(String str) {
        System.out.println("Hello " + str);
    };
}
