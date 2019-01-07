package chris.dream.jvm.proxy.my;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 5:45 2018-12-24
 */
public class DynamicProxy {
    public static <T> T newProxyInstance(ClassLoader classLoader,
                                         Class<?>[] interfaces, InvocationHandler invocationHandler) {
        new RealAdvice().before(null);

        T result = (T) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        new RealAdvice().after(null);

        return result;
    };
}
