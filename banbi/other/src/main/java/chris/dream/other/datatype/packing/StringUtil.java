package chris.dream.other.datatype.packing;

public class StringUtil {

	/**
	 * <p>Description: 实现字符串的反转及替换</p>
	 * @param originStr
	 * @return
	 */
	public static String reverse(String originStr) {
		if (originStr == null || originStr.length() <= 1)
			return originStr;
		return reverse(originStr.substring(1)) + originStr.charAt(0);
	}
}
