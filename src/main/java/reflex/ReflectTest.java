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
 * @date 2018��11��9��
 * 
 */
public class ReflectTest {
	
	// ������������
	@Test
	public void testGetClass() throws ClassNotFoundException{
		//1.ʵ����.class��ȡ��������
		Class<?> c1 = Student.class;
		//2.����.getClass()�õ�������
		Student stu = new Student();
		Class<?> c2 = stu.getClass();
		//3.Class.forName(���ȫ��)�õ�������
		Class<?> c3 = Class.forName("com.szl.reflect.test.Student");
		
		//˵��һ�������������ȫ��Ψһ��
		System.out.println(c1 == c2);//true
		System.out.println(c1 == c3);//true
	}
	
	// �������ʹ�����
	@Test
	public void testNewInstance() throws InstantiationException, IllegalAccessException{
		Class<?> c = Student.class;
		Student stu1 = (Student) c.newInstance();
		stu1.setName("zhangsaan");
		stu1.setAge(23);
		System.out.println(stu1);
	}
	
	
	// ��ȡ���һЩ��Ϣ
	@Test
	public void testGetClassMessage() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<?> c = Student.class;
		// ��ȡ����
		System.out.println(c.getName());
		
		// ��ȡ���е�public�������������ࣻgetDeclaredMethods()����������
		Method[] methods = c.getMethods();
		for (Method method : methods) {
			System.out.println(method.getReturnType() + ":" + method.getName());
		}
		
		// ��ȡ�������public��Ա����
		Field[] fields = c.getFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		
		// ��ȡ�������public���캯��
		Constructor<?>[] constructors = c.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor.getName());
		}
		// ��ȡ�޲ι��캯������ʵ��������
		Constructor<?> constructor = c.getDeclaredConstructor(null);
		Student stu = (Student) constructor.newInstance(null);
		System.out.println(stu);
	}
	
	// ��������Ĳ���
	@Test
	public void testOperateMethod() throws Exception{
		Class<?> c = Student.class;
		// ��ȡ�������Ķ���
		Method declaredMethod = c.getDeclaredMethod("testInvoke", String.class);
		// ���ø÷���
		String invoke = (String)declaredMethod.invoke(c.newInstance(), "a");
		System.out.println(invoke);//return a
	}
	
	// ���Է���
	@Test
	public void testGenerics() throws Exception{
		List<String> list1 = new ArrayList<String>();
		List<Integer> list2 = new ArrayList<Integer>();
		Class<?> c1 = list1.getClass();
		Class<?> c2 = list2.getClass();
		// ����true����list1��list2����������ͬ��˵�������Ǳ���ʱ����������ʱ
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