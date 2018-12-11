package reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * @author sunzl
 * @date 2018年10月17日
 *
 */
public class Test {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		List<String> list = new ArrayList<String>();
		list.add("a");
		
		Method declaredMethod = list.getClass().getDeclaredMethod("add", Object.class);
		Object invoke = declaredMethod.invoke(list, 100);
		System.out.println(invoke);
		for (Object obj : list) {
			System.out.println(obj);
		}
		System.out.println("------------------------");
		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			System.out.println(obj);
		}
	}
}
