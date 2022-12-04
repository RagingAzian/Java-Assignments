
public class Customer {
	private int age;
	private String name;

	public Customer(Customer customer) {
		this.age = customer.age;
		this.name = customer.name;
	}

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return ("Name: " + name + "\nAge: " + age);
	}
}
