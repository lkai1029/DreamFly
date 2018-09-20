package chris.dream.algorithm.string;

/**
 * @author Chris
 * @description: <p>反转字符串中的单词 III</p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例：
 *      输入: "Let's take LeetCode contest"
 *      输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * @date 下午 2:05 2018-09-14
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String sr = new ReverseWords().reverseWords(s);
        System.out.println(s);
        System.out.println("--->");
        System.out.println(sr);
    }

    /**
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if(null == s){
            throw new IllegalArgumentException("字符串长度为空");
        }
        String[] sArray = s.split(" ");
        int len = sArray.length;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < len; i++){
            result.append(reverseWord(sArray[i]));
            if(i != len - 1){
                result.append(" ");
            }
        }
        return result.toString();
    }

    public String reverseWord(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        char[] newCharAaary = new char[len];
        for(int i = 0; i < len; i++){
            newCharAaary[len - 1 - i] = charArray[i];
        }

        return new String(newCharAaary);
    }
}
