package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author sunzl
 * @date 2018年10月14日
 *
 */
public class CustomerSortTest {

	public static void main(String[] args) {
		List<Customer> list = new ArrayList<Customer>();
		list.add(new Customer("Jack", 25));
		list.add(new Customer("Allen", 25));
		list.add(new Customer("Mary", 23));
		list.add(new Customer("Tom", 24));
		
		Collections.sort(list, new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				int i = o1.getAge() - o2.getAge();
				//先根据age排序，age相同再根据name排序
				i = i == 0 ? o1.getName().compareTo(o2.getName()) : i;
				return i;
			}
		});
		
		for (Customer customer : list) {
			System.out.println(customer.toString());
		}
	}
}
