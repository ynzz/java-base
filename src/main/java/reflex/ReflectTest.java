package reflex;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author sunzl
 * @date 2018年11月9日
 * 
 */
public class ReflectTest {
	
	// 获得类的类类型
	@Test
	public void testGetClass() throws ClassNotFoundException{
		//1.实体类.class获取到类类型
		Class<?> c1 = Student.class;
		//2.对象.getClass()得到类类型
		Student stu = new Student();
		Class<?> c2 = stu.getClass();
		//3.Class.forName(类的全名)得到类类型
		Class<?> c3 = Class.forName("com.szl.reflect.test.Student");
		
		//说明一个类的类类型是全局唯一的
		System.out.println(c1 == c2);//true
		System.out.println(c1 == c3);//true
	}
	
	// 用类类型创建类
	@Test
	public void testNewInstance() throws InstantiationException, IllegalAccessException{
		Class<?> c = Student.class;
		Student stu1 = (Student) c.newInstance();
		stu1.setName("zhangsaan");
		stu1.setAge(23);
		System.out.println(stu1);
	}
	
	
	// 获取类的一些信息
	@Test
	public void testGetClassMessage() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<?> c = Student.class;
		// 获取类名
		System.out.println(c.getName());
		
		// 获取所有的public方法，包括父类；getDeclaredMethods()不包括父类
		Method[] methods = c.getMethods();
		for (Method method : methods) {
			System.out.println(method.getReturnType() + ":" + method.getName());
		}
		
		// 获取类的所有public成员变量
		Field[] fields = c.getFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		
		// 获取类的所有public构造函数
		Constructor<?>[] constructors = c.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor.getName());
		}
		// 获取无参构造函数，并实例化对象
		Constructor<?> constructor = c.getDeclaredConstructor(null);
		Student stu = (Student) constructor.newInstance(null);
		System.out.println(stu);
	}
	
	// 方法反射的操作
	@Test
	public void testOperateMethod() throws Exception{
		Class<?> c = Student.class;
		// 获取到方法的对象
		Method declaredMethod = c.getDeclaredMethod("testInvoke", String.class);
		// 调用该方法
		String invoke = (String)declaredMethod.invoke(c.newInstance(), "a");
		System.out.println(invoke);//return a
	}
	
	// 测试泛型
	@Test
	public void testGenerics() throws Exception{
		List<String> list1 = new ArrayList<String>();
		List<Integer> list2 = new ArrayList<Integer>();
		Class<?> c1 = list1.getClass();
		Class<?> c2 = list2.getClass();
		// 返回true，即list1和list2的类类型相同，说明泛型是编译时而不是运行时
		System.out.println(c1 == c2); // true
		
		list1.add("a");
		Method add = c1.getMethod("add", Object.class);
		add.invoke(list1, 100);
		System.out.println(list1.size());
		for (Object obj : list1) {
			System.out.println(obj);
		}
		System.out.println("--------------");
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
	}

}

class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8470075134128216866L;
	private String name;
	private int age;
	public String id;
	
	public Student() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String testInvoke(String name){
		System.out.println(name);
		return "return a";
	}
}