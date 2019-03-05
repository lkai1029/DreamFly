package chris.dream.database.java8.methodInvoker;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 2019-02-26
 */
public class Car {

    private int id;

    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void callCar(final Car car) {
        System.out.println("Call " + car.toString());
    }

    public static void sayHello(final Car car) {
        System.out.println("Hello~!" + car.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public void getName() {
        System.out.println(this.name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
