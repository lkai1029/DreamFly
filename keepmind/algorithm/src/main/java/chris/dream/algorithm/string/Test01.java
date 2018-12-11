package chris.dream.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Chris
 * @description: <p>无重复字符的最长子串</p>
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例 1:
 * 输入: "aabcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * @date 下午 4:13 2018-09-07
 */
public class Test01 {

    public static void main(String[] args) {
        Test01 test = new Test01();
        String s = "pwwkew";

        test.lengthOfLongestSubstring4Chris(s);
    }

    /**
     * 我的方法
     *      时间复杂度：O(n^2)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring4Chris(String s) {
        StringBuilder maxStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder tmpMaxStr = new StringBuilder();
            String tmp = null;
            for (int j = i; j < s.length() && tmpMaxStr.indexOf(tmp = String.valueOf(s.charAt(j))) < 0; j++) {
                tmpMaxStr.append(tmp);
            }
            if (tmpMaxStr.length() > maxStr.length()) {
                maxStr = tmpMaxStr;
            }
        }

        System.out.println(maxStr);
        return maxStr.length();
    }

    /**
     * 官方1-暴力法:
     *      时间复杂度：O(n^3)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)){
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * 官方2-滑动窗口：
     *      时间复杂度：O(n)
     *      String s = "pewwqkew";
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 官方3-优化的滑动窗口:
     *      时间复杂度：O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringBest(String s) {
        int n = s.length(), ans = 0;
        // current index of character
        /**
         * 用以保存每个字符最后无重复的位置
         */
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                // 从字符重复的位置重新开始
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
