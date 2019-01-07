package chris.dream.jvm.classfile;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 3:54 2018-12-12
 */
public class StaticResolution {

    public static void sayHello() {
        System.out.println("Hello world!");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}
