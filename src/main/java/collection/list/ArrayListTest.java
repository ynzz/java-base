package collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表长度可变的数组。允许对元素进行快速的随机访问，但是向ArrayList中插入与删除元素的速度较慢
 * 
 * @author sunzl
 * @date 2018年12月14日
 *
 */ 
public class ArrayListTest {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		System.out.println(list.size());
		String[] s = {};
		System.out.println(s.length);
		
	}
}
