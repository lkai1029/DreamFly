package chris.dream.database.java8.defaultmethod;

import chris.dream.database.java8.methodInvoker.Car;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 2019-02-26
 */
public class Tester {
    public static void main(String[] args) {
        Vehicle vehicle = new Car3();
        vehicle.print();
    }
}
