package chris.dream.algorithm.number;

import com.alibaba.fastjson.JSON;

/**
 * @author Chris
 * @description: <p>给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * PS:中位数--如果是奇数个，是中间的那个；如果是偶数个，是中间两个的平均数。
 * 你可以假设 nums1 和 nums2 不同时为空。</p>
 * 示例1：
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 中位数是 (2 + 3)/2 = 2.5
 * 示例2：
 * nums1 = [1, 3]
 * nums2 = [2]
 * 中位数是 2.0
 * @date 下午 5:54 2018-09-07
 */
public class Median {
    public static void main(String[] args) {
        Median test = new Median();
        int[] nums1 = {1, 2, 4, 5, 6, 7};
        System.out.println("A ---> " + JSON.toJSONString(nums1));
        int[] nums2 = {3, 5, 8, 9, 10, 11};
        System.out.println("B ---> " + JSON.toJSONString(nums2));

        long start = System.currentTimeMillis();

        System.out.println(test.findMedianSortedArrays(nums1, nums2));

        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }

    /**
     * 时间复杂度：O(log(min(m,n)))，
     * 首先，查找的区间是 [0, m]。 而该区间的长度在每次循环之后都会减少为原来的一半。
     * 所以，我们只需要执行 log(m) 次循环。由于我们在每次循环中进行常量次数的操作，所以时间复杂度为 O(log(m))。
     * 由于 m <= n，所以时间复杂度是 O(log(min(m,n)))。
     * <p>
     * 空间复杂度：O(1)， 我们只需要恒定的内存来存储 99 个局部变量， 所以空间复杂度为 O(1)。
     *
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        /**
         * 以i作为A的切割索引，j作为B的切割索引，i和j的左边组合，与右边组合满足中位数的要求
         * i = m - i; j = n - j 左右个数相同
         * => i + j = m - i + n - j + 1; // 为何加1？i，j如果是奇数长度的数组的中位数，包含1/2的可能
         * => 2i + 2j = m + n + 1;
         * => j = (m + n + 1) / 2 - i; // 必要条件
         *
         * halfLen : 整合为一个数组的中位数索引
         * n必须大于m长度：如果m大于n，可能会出现m的一半i大于(m + n + 1)/2 的情况，使j小于0
         */
        int m = A.length;
        int n = B.length;
        // to ensure m<=n
        if (m > n) {
            /**
             * 替换，使A为长度短的数组
             */
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        System.out.println("m = " + m + " ; n = " + n);

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;

        /**
         * 完成条件：i和j的左边是整体中位数以左的部分
         *      B[j - 1] <= A[i] && A[i - 1] <= B[j]
         */
        while (iMin <= iMax) {
            System.out.println("===============");
            System.out.println("iMax : " + iMax + "; iMin : " + iMin);
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            System.out.println("i = " + i + "; j = " + j);

            if (i < iMax && B[j - 1] > A[i]) {
                System.out.println("B[j-1] : " + B[j - 1]);
                System.out.println("A[i] : " + A[i]);
                System.out.println("i太小：i < iMax && B[j-1] > A[i]");
                // i is too small. i的取值太小，从现在i的位置扩大最小值
                iMin = i + 1;
            } else if (i > iMin && A[i - 1] > B[j]) {
                System.out.println("A[i-1] : " + A[i - 1]);
                System.out.println("B[j] : " + B[j]);
                System.out.println("i太大：i > iMin && A[i-1] > B[j]");
                // i is too big. i的取值太大，从现在i的位置缩小最大值
                iMax = i - 1;
            } else { // i is perfect
                System.out.println("i is perfect!");

                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    // 取A[i - 1]和B[j - 1]中最大的作为左侧做大的数
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }

                /**
                 * 如果总数是奇数，则返回左侧最大的数，就是中位数
                 */
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    // 取A[i]和B[j]中较小的一个作为右侧最小的数
                    minRight = Math.min(B[j], A[i]);
                }

                /**
                 * 如果总数是偶数，返回左侧最大和右侧最小的平均数作为中位数
                 */
                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0.0;
    }
}
