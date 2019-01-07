package chris.dream.jvm.threadlocal;

import java.text.SimpleDateFormat;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 3:54 2018-12-20
 */
public class Constant {

    public static ThreadLocal<SimpleDateFormat> FORMAT_THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static SimpleDateFormat FORMATE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
