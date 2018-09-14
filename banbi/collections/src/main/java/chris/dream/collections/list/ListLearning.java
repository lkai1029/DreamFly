package chris.dream.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 9:40 2018-08-24
 */
public class ListLearning {
    public static void main(String[] args) {
        List<String> arrList = new ArrayList<>();
        arrList.add("1");


        List<String> linList = new LinkedList<>();

        System.out.println(Integer.MAX_VALUE);

        String id = "11111111111111111X";

        String regex = "\\d{17}[X|x|\\d]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);
        if (!matcher.find()) {
            // 直接不要这条记录
        } else {
            System.out.println(matcher.group(0));
        }
    }
}
