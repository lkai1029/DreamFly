package chris.dream.other.myenum;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 10:22 2018-09-28
 */
public class EnumTest {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int sum = StrategyEnum.Add.exec(a, b);
        System.out.println("Sum = " + sum);
        String add = StrategyEnum.Add.getValue();
        System.out.println("当前运算符：" + add);
    }
}
