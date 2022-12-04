import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	private int orderNo;
	private ArrayList<Beverage> beverageList = new ArrayList<Beverage>();

	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = cust;
		this.orderNo = generateOrder();
	}

	public Order(Order ord) {
		this.orderTime = ord.orderTime;
		this.orderDay = ord.orderDay;
		this.customer = ord.customer;
		this.orderNo = generateOrder();
	}

	public int generateOrder() {
		Random rand = new Random();
		return rand.nextInt(10000, 90001);
	}

	public int getOrderNo() {
		return orderNo;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public Day getOrderDay() {
		return orderDay;
	}

	public Customer getCustomer() {
		return new Customer(customer);
	}

	public Day getDay() {
		return orderDay;
	}

	public boolean isWeekend() {
		return (orderDay == Day.SUNDAY || orderDay == Day.SATURDAY);
	}

	public Beverage getBeverage(int itemNo) {
		ArrayList<Beverage> beverageListCopy = new ArrayList<Beverage>(beverageList);
		return beverageListCopy.get(itemNo);
	}

	public int getTotalItems() {
		return beverageList.size();
	}

	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		beverageList.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}

	public void addNewBeverage(String bevName, Size size) {
		beverageList.add(new Alcohol(bevName, size, isWeekend()));
	}

	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		beverageList.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}

	public double calcOrderTotal() {
		double total = 0;
		for (Beverage bev : beverageList) {
			total += bev.calcPrice();
		}
		return total;
	}

	public int findNumOfBeveType(Type type) {
		int count = 0;
		for (Beverage bev : beverageList) {
			if (bev.getBeverageType() == type)
				count++;
		}
		return count;
	}

	public String toString() {
		return ("Order Number: " + orderNo + "\nOrder Time: " + orderTime + "\nDay: " + orderDay + "\nCustomer Name: "
				+ customer.getName() + "\nCustomer Age: " + customer.getAge() + "\nList of Beverages: "
				+ Arrays.toString(beverageList.toArray()));
	}

	public int compareTo(Order anotherOrder) {
		if (this.orderNo == anotherOrder.orderNo)
			return 0;
		else if (this.orderNo > anotherOrder.orderNo)
			return 1;
		else {
			return -1;
		}
	}

}
