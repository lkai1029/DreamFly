package chris.dream.javabasics;

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


    }
}
