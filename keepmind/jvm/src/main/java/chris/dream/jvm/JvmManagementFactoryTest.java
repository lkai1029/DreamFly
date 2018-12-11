package chris.dream.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class JvmManagementFactoryTest {

    public static void main(String[] args) {

        Map<String, byte[]> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {

            MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean(); // 获取 Java 虚拟机的内存系统的管理 Bean

            MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage(); //椎内存使用情况

            long totalMemorySize = memoryUsage.getInit(); //初始的总内存
            long maxMemorySize = memoryUsage.getMax(); //最大可用内存
            long usedMemorySize = memoryUsage.getUsed(); //已使用的内存

            System.out.println(totalMemorySize * 1D / 1024 / 1024 + "m " + maxMemorySize * 1D / 1024 / 1024 + "m "
                    + usedMemorySize * 1D / 1024 / 1024 + "m");

            double usage = usedMemorySize * 1.0 / totalMemorySize;
            System.out.println("内存占用率：" + usage);


            BigDecimal bd = new BigDecimal(usage * 100);
            usage = bd.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();

            System.out.println(usage + "%");


            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            map.put(String.valueOf(i), new byte[10 * 1024 * 1024]);

        }

    }
}
