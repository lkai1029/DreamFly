package chris.dream.jvm.proxy.my;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 5:51 2018-12-24
 */
public class RealAdvice implements IAvice {
    @Override
    public Object before(Object[] args) {
        String result = "I'm before";
        return result;
    }

    @Override
    public Object after(Object[] args) {
        String after = "I'm after";
        return after;
    }
}
