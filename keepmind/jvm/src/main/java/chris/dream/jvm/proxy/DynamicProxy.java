package chris.dream.jvm.proxy;

import lombok.extern.log4j.Log4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 8:36 2018-12-23
 */
@Log4j
public class DynamicProxy implements InvocationHandler {
    /**
     * 目标对象
     */
    private Object target;

    /**
     * 通过反射来实例化目标对象
     * @param object
     * @return
     */
    public Object bind(Object object){
        this.target = object;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("A");
        //通过反射机制来运行目标对象的方法
        Object result = method.invoke(this.target, args);
        System.out.println("B");
        return result;
    }
}
