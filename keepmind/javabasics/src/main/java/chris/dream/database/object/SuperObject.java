package chris.dream.database.object;

/**
 * @author Chris
 * @description: <p>超级父类Object</p>
 * @date 下午 2:33 2018-10-29
 */
public class SuperObject {

    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println("HashCode : " + obj.hashCode());

        // o1.getClass() == o2.getClass()
        Class<?> clazz = obj.getClass();
        System.out.println("Class : " + clazz);
        System.out.println("ClassName : " + clazz.getName());

        TestObject t1 = new TestObject();
        t1.setKey("k1");
        t1.setValue("v1");

        try {
            TestObject t2 = (TestObject) t1.clone();
            System.out.println(t2);

            System.out.println(t1 == t2);
            System.out.println(t1.equals(t2));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
