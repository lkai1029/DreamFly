package chris.dream.database.java8.methodInvoker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Chris
 * @description: <p>函数调用</p>
 * @date 2019-02-26
 */
public class MethodInvoker {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        /**
         * 构造器引用：它的语法是Class::new
         */
        Supplier<Car> supplier = Car :: new;
        final Car car = supplier.get();
        car.setId(1);
        car.setName("A");

        final List< Car > cars = Arrays.asList(car);
        /**
         * 静态方法引用：它的语法是Class::static_method，实例如下：
         */
        cars.forEach(Car :: sayHello);
        /**
         * 特定类的任意对象的方法引用：它的语法是Class::method实例如下：
         */
        cars.forEach(Car :: repair);
        cars.forEach(Car :: getName);
        /**
         * 特定对象的方法引用：它的语法是instance::method实例如下：
         */
        cars.forEach(car :: callCar);
    }

    public static void test2() {
        List names = new ArrayList();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(System.out::println);
    }
}
