package chris.dream.jvm.proxy.my;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 5:45 2018-12-24
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething(String str) {
        System.out.println("Hello " + str);
    }
}
