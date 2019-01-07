package chris.dream.database.object;

import lombok.*;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 2:49 2018-10-29
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TestObject implements Cloneable{

    private String key;

    private Object value;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
