package chris.dream.algorithm.sort.impl;

import chris.dream.algorithm.sort.Sort;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 11:54 2019-01-11
 */
public class SelectSort extends Sort {

    public SelectSort(String name) {
        super(name);
    }

    /**
     * 选择排序
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列起始位置。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @param numbers
     */
    @Override
    public int[] doSort(int[] numbers) {
        int size = numbers.length;
        int temp;
        for (int i = 0; i < size; i++) {
            int k = i;
            for (int j = size - 1; j > i; j--) {
                if (numbers[j] < numbers[k]) {
                    k = j;
                }
            }
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
        return numbers;
    }
}
