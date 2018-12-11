package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sunzl
 * @date 2018年10月14日
 *
 */
public class IntegerSortTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(2);
		list.add(1);
		Collections.sort(list);//正序
//      Collections.reverse(list); //倒序
		for (Integer i : list) {
		    System.out.println(i);
		}
	}
}
