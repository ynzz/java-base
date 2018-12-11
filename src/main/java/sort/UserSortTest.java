package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sunzl
 * @date 2018年10月14日
 *
 */
public class UserSortTest {

	public static void main(String[] args) {
		List<User> list = new ArrayList<User>();
		list.add(new User("Jack", 25));
		list.add(new User("Allen", 25));
		list.add(new User("Mary", 23));
		list.add(new User("Tom", 24));
		Collections.sort(list);
		for (User user : list) {
			System.out.println(user.toString());
		}
	}
}
