package chris.dream.algorithm.sort.impl;

import chris.dream.algorithm.sort.Sort;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 10:35 2019-01-11
 */
public class BubbleSort extends Sort {
    public BubbleSort(String name) {
        super(name);
    }

    /**
     * 冒泡法排序
     * 比较相邻的元素。如果第一个比第二个小，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最小的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param numbers 需要排序的整型数组
     * @return
     */
    @Override
    public int[] doSort(int[] numbers) {
        int length = numbers.length;
        for(int i = 0; i < length - 1; i++) {
            for(int j = i + 1; j < length; j++){
                if (numbers[i] > numbers[j]) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
        return numbers;
    }

    public int[] realSort(int[] numbers) {
        int length = numbers.length;
        for(int i = 1; i < length; i++) {
            /**
             * 不断把最大的放在头上
             */
            for(int j = 0; j < length - i; j++){
                if (numbers[j] > numbers[j + 1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j] = tmp;
                }
            }
        }
        return numbers;
    }

}
