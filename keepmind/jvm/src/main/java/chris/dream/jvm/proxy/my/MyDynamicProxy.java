package chris.dream.jvm.proxy.my;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 5:45 2018-12-24
 */
public class MyDynamicProxy extends DynamicProxy {

    public static <T> T newProxyInstance(Object object) {
        new RealAdvice().before(null);

        ClassLoader classLoader = object.getClass().getClassLoader();
        Class<?>[] interfaces = object.getClass().getInterfaces();
        InvocationHandler invocationHandler = new MyInvocationHandler(object);
        T result = (T) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        new RealAdvice().after(null);

        return result;
    };
}
