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
     * 快速排序，时间复杂度：O(nlogn)
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
            /**
             * 直到j大于i停止自循环，最后：i左侧全是小于base的，右侧全是大于base的
             * i位置表示小于等于base的最大数，j位置表示大于等于base的最小数
             */
            do {
                // 比基准小的放在一侧：当前位置的值小于基准，判断后一个
                while ((numbers[i] < base) && (i < end)) {
                    i++;
                }
                // 比基准大的放在另一侧：当前位置的值大于基准，判断前一个
                while ((numbers[j] > base) && (j > start)) {
                    j--;
                }
                // 跳出之后，如果i <= j，说明i之前的都小于基准，j之后都是大于基准的值
                // |6| 5 7 8 4 3 2 |1| 9
                if (i <= j) {
                    // 此时将i,j的值互换
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    // |1| 5 7 8 4 3 2 |6| 9

                    // 互换之后再次满足上述条件：[i] < base, [j] > base
                    i++;
                    j--;
                    // 1 |5| 7 8 4 3 |2| 6 9
                }
            } while (i <= j);
            /**
             * 如果start < j，表示有比基准小的值，递归将小于基准的进行快排
             */
            if (start < j) {
                sort(numbers, start, j);
            }
            /**
             * 如果end > i，表示有比基准大的值，递归将大于基准的进行快排
             */
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

    /**
     * 快速排序进阶
     * @param numbers
     * @param start
     * @param end
     * @return
     */
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
        /**
         * 将numbers[start]和numbers[i]的值互换，即：将基准值放在中间[i]的位置
         */
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
