package chris.dream.database.string;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 11:50 2018-09-17
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println("test01:");
        test01();
        System.out.println("test02:");
        test02();
    }

    public static void test01() {
        String a = "Programming";
        String b = new String("Programming");
        String c = "Program" + "ming";

        System.out.println(a == b); // false
        System.out.println(a == c); // true
        System.out.println(a.equals(b)); // true
        System.out.println(a.equals(c)); // true
        System.out.println(a.intern() == b.intern()); // true
    }

    public static void test02() {
        String s1 = "HelloWorld";
        String s2 = new String("HelloWorld");
        String s3 = "Hello";
        String s4 = "World";
        String s5 = "Hello" + "World";
        String s6 = s3 + s4;

        System.out.println(s1 == s2); // false
        System.out.println(s1 == s5); // true
        System.out.println(s1 == s6); // false
        System.out.println(s1 == s6.intern()); // true
        System.out.println(s2 == s2.intern()); // false


    }

}
