package chris.dream.algorithm.sort;

import chris.dream.algorithm.sort.impl.BubbleSort;
import chris.dream.algorithm.sort.impl.QuickSort;
import chris.dream.algorithm.sort.impl.SelectSort;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 10:29 2019-01-11
 */
public class TestSort {

    private static int[] numbers = {1, 9, 4, 2, 3, 5, 8, 6, 7};

    public static void main(String[] args) {
        print(new BubbleSort("冒泡排序").sort(numbers));
        print(new BubbleSort("真·冒泡排序").realSort(numbers));
        print(new QuickSort("快速排序").sort(numbers));
        print(new QuickSort("快速排序").sortA(numbers));
        print(new SelectSort("选择排序").sort(numbers));
    }

    /**
     * 打印数组
     * @param numbers
     */
    private static void print(int[] numbers) {
        System.out.println("Sort result:");
        if (null == numbers) {
            return;
        }
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.print("\r\n");
    }
}
