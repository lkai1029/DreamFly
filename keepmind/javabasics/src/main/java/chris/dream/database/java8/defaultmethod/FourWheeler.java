package chris.dream.database.java8.defaultmethod;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 2019-02-26
 */
public interface FourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车!");
    }
}
