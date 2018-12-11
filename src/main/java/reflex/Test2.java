package reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author sunzl
 * @date 2018年11月10日
 *
 */
public class Test2 {

	// 测试泛型
	@Test
	public static void testGenerics() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<String> list = new ArrayList<String>();
		list.add("a");
		Class<List<String>> c = (Class<List<String>>) list.getClass();
		Method add = c.getDeclaredMethod("add", Object.class);
		add.invoke(list, 100);
		for (Object obj : list) {
			System.out.println(obj);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		new Test2().testGenerics();
	}
}
