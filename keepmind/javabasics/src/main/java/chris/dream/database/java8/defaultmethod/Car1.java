package chris.dream.database.java8.defaultmethod;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 2019-02-26
 */
public class Car1 implements Vehicle, FourWheeler {
    /**
     * 创建自己的默认方法，来覆盖重写接口的默认方法
     */
    @Override
    public void print() {
        System.out.println("俺是辆ce");
    }
}
