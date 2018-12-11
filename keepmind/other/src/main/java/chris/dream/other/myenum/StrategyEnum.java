package chris.dream.other.myenum;

/**
 * @author Chris
 */
public enum StrategyEnum {
    Add("+"){
        @Override
        public int exec(int a, int b){
            return a + b;
        }
    },
    Sub("-"){
        @Override
        public int exec(int a, int b){
            return a - b;
        }
    };

    /**
     * 1.构造方法，确定枚举的类型
     * @param value
     */
    StrategyEnum(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return this.value;
    }
    public abstract int exec(int a, int b);
}
