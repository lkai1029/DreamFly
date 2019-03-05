package chris.dream.database.java8.defaultmethod;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 2019-02-26
 */
public class Car2 implements Vehicle, FourWheeler {
    /**
     * 使用 super 来调用指定接口的默认方法：
     */
    @Override
    public void print() {
        Vehicle.super.print();
    }
}
