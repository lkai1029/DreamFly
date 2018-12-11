package chris.dream.collections.list.constructor;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 4:38 2018-09-26
 */
public class ConstructList {

    public static void main(String[] args) {
        System.out.println("构建：" + JSON.toJSONString(buildTest()));
        System.out.println("排序后：" + JSON.toJSONString(sortTest()));

        testForEach();

    }
    public static List<String> buildTest() {
        List<String> list = new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("c");
            }
        };
        return list;
    }

    public static List<String> sortTest(){
        List<String> list = buildTest();
        // String::compareToIgnoreCase)等同于(x,y)->x.compareToIgnoreCase(y)
        Collections.sort(list, String :: compareToIgnoreCase);
        return list;
    }

    public static void testForEach(){
        List<String> list = buildTest();
        System.out.println("forEach : ");
        list.forEach(s -> System.out.println(s));
        System.out.println("lambda : ");
        List<String> mList = list.stream().map(s -> {return s + "s";}).collect(toList());
        System.out.println(mList);
    }
}
