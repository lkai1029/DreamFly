package chris.dream.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author Chris
 * @description: <p>路径工具类</p>
 * @date 上午 11:54 2018-08-20
 */
@Slf4j
public class PathUtil {
    private final static String JAR_ENDING = ".jar";

    private final static String DEFAULT_ENV = "CHRIS_HOME";

    /**
     * 获取资源目录
     * @param env 环境变量key
     * @return
     */
    public static String getResourcePath(String env){
        log.debug("Get resource path");
        String resourcePath = null;
        try {
            if(StringUtils.isEmpty(env)){
                env = DEFAULT_ENV;
            }
            resourcePath = System.getenv(env);
            if(StringUtils.isEmpty(resourcePath)) {
                resourcePath = PathUtil.class.getClassLoader().getResource("").getPath();
            }
            resourcePath = URLDecoder.decode(resourcePath, "utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error("", e);
        }
        if (resourcePath.endsWith(JAR_ENDING)) {
            resourcePath = resourcePath.substring(0, resourcePath.lastIndexOf("/") + 1);
        }
        /**
         * 得到windows下的正确路径
         */
        resourcePath = new File(resourcePath).getAbsolutePath();

        log.debug("Resource path : " + resourcePath);

        return resourcePath;
    }

    /**
     * 获取资源目录(采用默认环境变量)
     * @return
     */
    public static String getResourcePath(){
        return getResourcePath(null);
    }

}
