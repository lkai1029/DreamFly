package chris.dream.database.java8.defaultmethod;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 2019-02-26
 */
public interface Vehicle {
    /**
     * 实际上也是一个接口，但是有默认实现
     */
    default void print(){
        System.out.println("我是一辆车!");
    }

    /**
     * Java 8 的另一个特性是接口可以声明（并且可以提供实现）静态方法。
     */
    static void blowHorn(){
        System.out.println("按喇叭!!!");
    }
}
