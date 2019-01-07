package chris.dream.dp.singleton;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 3:45 2018-12-21
 */
public enum SingletonEnum {
    instance;

    private String name;

    public void doSomeThing(){
        System.out.println("Hello.");
    }
}
