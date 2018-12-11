package bigdecimal;

import java.math.BigDecimal;

/**
 * @author sunzl
 * @date 2018年10月14日
 *
 */
public class BigDecimalTest {

	public static void main(String[] args) {
		BigDecimal bg1 = new BigDecimal("1");
		BigDecimal bg2 = new BigDecimal("1");
		System.out.println(bg1 == bg2);
		System.out.println(bg1.compareTo(bg2));
		
		Integer a = 128;
		Integer b = 128;
		System.out.println(a == b);
	}
}
