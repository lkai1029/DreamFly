package chris.dream.database.java8.functionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Chris
 * @description: <p>函数式接口</p>
 * @date 2019-02-26
 *
 * Java 8为函数式接口引入了一个新注解@FunctionalInterface，
 * 主要用于编译级错误检查，加上该注解，当你写的接口不符合函数式接口定义的时候，编译器会报错。
 */
public class FunctionInterface2 {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        list.stream().filter(n -> n % 2 == 0).forEach(System.out :: println);

        System.out.println(list);
    }

}
