package chris.dream.other.datatype.primitive;

import java.math.BigDecimal;

public class DoubleUtil {
	
	public static void main(String[] args) {
		double d = 1.1234567890123456789;
//		double d = 1.5;
		for(int i = 0; i < 20; i ++){
			System.out.println(i);
			System.out.println(roundHalfUp(d, i));
			System.out.println(roundHalfDown(d, i));
			System.out.println(roundUp(d, i));
			System.out.println(roundDown(d, i));
		}
	}
	
	/**
	 * <p>Description: 四舍五入</p>
	 * @param d 原始数据
	 * @param precision 精度
	 * @return
	 */
	public static double roundHalfUp(double d, int precision) {
		BigDecimal b = new BigDecimal(d);
		d = b.setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue();        
		return d;
	}

	/**
	 * <p>Description: 五舍六入</p>
	 * @param d 原始数据
	 * @param precision 精度
	 * @return
	 */
	public static double roundHalfDown(double d, int precision) {
		BigDecimal b = new BigDecimal(d);
		d = b.setScale(precision, BigDecimal.ROUND_HALF_DOWN).doubleValue();        
		return d;
	}
	/**
	 * <p>Description: 进位</p>
	 * @param d 原始数据
	 * @param precision 精度
	 * @return
	 */
	public static double roundUp(double d, int precision) {
		BigDecimal b = new BigDecimal(d);
		d = b.setScale(precision, BigDecimal.ROUND_UP).doubleValue();        
		return d;
	}
	/**
	 * <p>Description: 退位</p>
	 * @param d 原始数据
	 * @param precision 精度
	 * @return
	 */
	public static double roundDown(double d, int precision) {
		BigDecimal b = new BigDecimal(d);
		d = b.setScale(precision, BigDecimal.ROUND_DOWN).doubleValue();        
		return d;
	}

}
