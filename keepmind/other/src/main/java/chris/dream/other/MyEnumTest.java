package chris.dream.other;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 11:06 2019-01-14
 */
public class MyEnumTest {
    public static void main(String[] args) {
        for(MyEnum myEnum : MyEnum.values()) {
            System.out.println(myEnum.getCode());
        }

        System.out.println(MyEnum.valueOf("RED").getColor());
    }
}
