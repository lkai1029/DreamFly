package chris.dream.jvm.proxy.my;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 5:50 2018-12-24
 */
public interface IAvice {

    Object before(Object[] args);

    Object after(Object[] args);
}
