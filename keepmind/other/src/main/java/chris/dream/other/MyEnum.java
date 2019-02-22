package chris.dream.other;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 11:06 2019-01-14
 */
@Getter
public enum MyEnum {
    RED("red", "红色"),
    YELLOW("yellow", "黄色"),
    BLUE("blue", "蓝色");

    private String code;

    private String color;

    MyEnum(String code, String color) {
        this.code = code;
        this.color = color;
    }
}
