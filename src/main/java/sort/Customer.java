package sort;


/**
 * @author sunzl
 * @date 2018年10月14日
 *
 */
public class Customer{

	private String name;
	
	private int age;

	/**
	 * @param name
	 * @param age
	 */
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
		return "Customer [name=" + name + ", age=" + age + "]";
	}
	
}
