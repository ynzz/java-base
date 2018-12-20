package jdk8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author sunzl
 * @date 2018年12月20日
 *
 */
public class Lambda {

	
	public static void main(String[] args) {
		
		Lambda lambda = new Lambda();
		lambda.test1();
		lambda.test2();
		lambda.test3();
	}
	
	// 常规的Collections的排序的写法，需要对接口方法重写
	public void test1() {
		List<String> list = Arrays.asList("a", "c", "b");
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	// 带参数类型的Lambda的写法
	public void test2(){
		List<String> list = Arrays.asList("a", "c", "b");
		Collections.sort(list, (Comparator<? super String>) (String a, String b) -> {
			return b.compareTo(a);
		});
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	// 不带参数的lambda的写法
	public void test3(){
		List<String> list = Arrays.asList("a", "c", "b");
		Collections.sort(list, (a, b) -> b.compareTo(a));
		for (String string : list) {
			System.out.println(string);
		}
	}
}
