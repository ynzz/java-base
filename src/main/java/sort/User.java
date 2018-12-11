package sort;

/**
 * @author sunzl
 * @date 2018年10月14日
 *
 */
public class User implements Comparable<User>{

	private String name;
	
	private int age;
	
	
	/**
	 * @param name
	 * @param age
	 */
	public User(String name, int age) {
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
		return "User [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(User o) {
		int i = this.getAge() - o.getAge();
		//先根据age排序，age相同再根据name排序
		i = i == 0 ? this.name.compareTo(o.getName()) : i;
		return i;
	}

}
