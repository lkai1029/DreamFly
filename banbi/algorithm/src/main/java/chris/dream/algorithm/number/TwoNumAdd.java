package chris.dream.algorithm.number;

/**
 * @author Chris
 * @description: <p>两数相加</p>
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @date 上午 11:59 2018-09-07
 */
public class TwoNumAdd {

    public static void main(String[] args) {
        TwoNumAdd solution = new TwoNumAdd();
        ListNode l1 = solution.buildNode("9");

        ListNode l2 = solution.buildNode("9999999991");

        ListNode node = solution.addTwoNumbers(l1, l2);
        System.out.println(node);

        node = solution.addTwoNumbersBest(l1, l2);
        System.out.println(node);
    }

    /**
     * 链表的尾插法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode tmp = null;
        /**
         * 是否进位
         */
        boolean carry = false;
        while (l1 != null || l2 != null || carry) {
            int num = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            if (carry) {
                num++;
            }

            if (num < 10) {
                carry = false;
            } else {
                carry = true;
            }

            ListNode node = new ListNode(num % 10);
            if (tmp == null) {
                tmp = node;
                result = tmp;
            } else {
                tmp.next = node;
                tmp = tmp.next;
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return result;
    }

    public ListNode buildNode(String numStr) {
        char[] numChars = numStr.toCharArray();
        if (numChars == null && numChars.length < 1) {
            throw new IllegalArgumentException("No sum solution");
        }
        ListNode numNode = new ListNode(Integer.parseInt(numChars[numChars.length - 1] + ""));

        ListNode tmp = numNode;
        for (int i = numChars.length - 2; i >= 0; i--) {
            ListNode next = new ListNode(Integer.parseInt(numChars[i] + ""));
            tmp.next = next;
            tmp = tmp.next;
        }

        return numNode;
    }

    /**
     * 官方方法：
     * 将当前结点初始化为返回列表的哑结点。
     * 将进位 carry 初始化为 0。
     * 将 p 和 q 分别初始化为列表 l1 和 l2 的头部。
     * 遍历列表 l1 和 l2 直至到达它们的尾端。
     *     将 x 设为结点 p 的值。如果 p 已经到达 l1 的末尾，则将其值设置为 0。
     *     将 y 设为结点 q 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0。
     *     设定 sum = x + y + carry。
     *     更新进位的值，carry = sum / 10。
     *     创建一个数值为 (sum \bmod 10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
     *     同时，将 p 和 q 前进到下一个结点。
     * 检查 carry = 1 是否成立，如果成立，则向返回列表追加一个含有数字 1 的新结点。
     * 返回哑结点的下一个结点。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersBest(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
