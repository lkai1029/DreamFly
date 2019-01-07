package chris.dream.jvm.proxy.my;

import java.lang.reflect.InvocationHandler;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 6:04 2018-12-24
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler invocationHandler = new MyInvocationHandler(subject);
        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), invocationHandler);
        proxy.doSomething("World!");

        proxy = MyDynamicProxy.newProxyInstance(subject);
        proxy.doSomething("Chris!");
    }
}
