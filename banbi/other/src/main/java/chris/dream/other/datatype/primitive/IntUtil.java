package chris.dream.other.datatype.primitive;

public class IntUtil {

	public static void main(String[] args) {
		int i = 0x2f;
		toBinary(i);
		
		double j = 1.461e3;
		System.out.println(j);
		
//		float f = Float.MAX_VALUE;
		
		testMove();
		
		System.out.println(Math.round(j));
		
	}
	
	public static void toBinary(int i) {
		System.out.println(i);
		System.out.println(Integer.toBinaryString(i));
	}
	
	public static void integerTest() {
		Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
		/**
		 * Integer源码
		 */
		System.out.println(f1 == f2); // true，-128~127之间，不会new Integer对象
		System.out.println(f3 == f4); // false，大于127或小于-128，则会new Integer对象
		
		System.out.println(2 << 3);
		
		A:{
			for(int i = 0; i < 100; i++) {
				
				for(int j = 0; j < 100; j++) {
					
					for(int k = 0; k < 100; k++) {
						System.out.println(k);
						if(k == 5) {
							break A;
						}
					}
				}
			}
		}

	}
	
	public static void testMove() {
		System.out.println("Test move");
		int i = 100;
		System.out.println(Integer.toBinaryString(i));
		i >>= 2;
		System.out.println(i);
		
		i = -15;
		System.out.println(Integer.toBinaryString(i));
		i >>= 2;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(i);
		
		System.out.println(Integer.toBinaryString(i));
		i >>>= 3;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(i);
	}
	
	public static void testForEach() {
			
	}
}
