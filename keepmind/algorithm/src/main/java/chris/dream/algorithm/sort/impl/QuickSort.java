package chris.dream.algorithm.sort.impl;

import chris.dream.algorithm.sort.Sort;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 11:07 2019-01-11
 */
public class QuickSort extends Sort {
    public QuickSort(String name) {
        super(name);
    }

    /**
     * 快速排序
     *
     * 从数列中挑出一个元素，称为“基准”
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     * 在这个分割之后，该基准是它的最后位置。这个称为分割（partition）操作。
     * 递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *
     * @param numbers
     * @param start
     * @param end
     */
    public int[] sort(int[] numbers, int start, int end) {
        if (start < end) {
            /**
             * 选定的基准值（第一个数值作为基准值）
             */
            int base = numbers[start];
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end)) {
                    i++;
                }
                while ((numbers[j] > base) && (j > start)) {
                    j--;
                }
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j) {
                sort(numbers, start, j);
            }
            if (end > i) {
                sort(numbers, i, end);
            }
        }
        return numbers;
    }

    @Override
    public int[] doSort(int[] numbers) {
        return sort(numbers, 0, numbers.length - 1);
    }

    public int[] sortA(int[] numbers, int start, int end) {
        if(start >= end) {
            return numbers;
        }
        int i = start;
        int j = end;
        int base = numbers[start];
        while(i != j) {
            while(numbers[j] >= base && j > i) {
                j--;
            }
            while(numbers[i] <= base && i < j) {
                i++;
            }
            if(i < j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
        numbers[start] = numbers[i];
        numbers[i] = base;
        sortA(numbers, start, i - 1);
        sortA(numbers, i + 1, end);

        return numbers;
    }

    public int[] sortA(int[] numbers) {
        return sortA(numbers, 0, numbers.length - 1);
    }
}
