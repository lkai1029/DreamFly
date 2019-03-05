package chris.dream.database.java8.functionInterface;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 2019-02-26
 */
@FunctionalInterface
public interface GreetingInterface {

    void sayMessage(String message);

    /**
     * 函数式接口里允许定义默认方法
     *
     * 函数式接口里是可以包含默认方法，因为默认方法不是抽象方法，其有一个默认实现，所以是符合函数式接口的定义的；
     * @param message
     */
    default void sayBye(String message) {
        System.out.println("Bye");
    }

    /**
     * 函数式接口里允许定义静态方法
     *
     * 函数式接口里是可以包含静态方法，因为静态方法不能是抽象方法，是一个已经实现了的方法，所以是符合函数式接口的定义的；
     */
    static void printHello(){
        System.out.println("Hello");
    }

    /**
     * 函数式接口里允许定义 java.lang.Object 里的 public 方法
     *
     * 函数式接口里是可以包含Object里的public方法，这些方法对于函数式接口来说，
     * 不被当成是抽象方法（虽然它们是抽象方法）；因为任何一个函数式接口的实现，
     * 默认都继承了 Object 类，包含了来自 java.lang.Object 里对这些抽象方法的实现；
     * @param object
     * @return
     */
    @Override
    boolean equals(Object object);
}
