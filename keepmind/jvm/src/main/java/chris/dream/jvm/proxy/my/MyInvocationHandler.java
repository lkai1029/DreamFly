package chris.dream.jvm.proxy.my;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 5:49 2018-12-24
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object obj;

    public MyInvocationHandler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}
