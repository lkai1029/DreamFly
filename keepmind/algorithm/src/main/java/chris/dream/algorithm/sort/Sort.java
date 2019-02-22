package chris.dream.algorithm.sort;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 5:22 2019-02-21
 */
public abstract class Sort {

    private String name;

    public Sort(String name) {
        this.name = name;
    }

    public int[] sort(int[] numbers) {
        System.out.println("[" + name + "]排序 ---");
        print(numbers);
        return doSort(numbers);
    }

    protected abstract int[] doSort(int[] numbers);

    /**
     * 打印数组
     * @param numbers
     */
    private static void print(int[] numbers) {
        System.out.println("排序前：");
        if (null == numbers) {
            return;
        }
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.print("\r\n");
    }
}
