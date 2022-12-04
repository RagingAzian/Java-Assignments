import java.util.ArrayList;
import java.util.Arrays;

public class BevShop implements BevShopInterface {
	private int noOfAlcoholDrinks;
	ArrayList<Order> orders = new ArrayList<Order>();

	public boolean isValidTime(int time) {
		return (time >= MIN_TIME && time <= MAX_TIME);
	}

	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public boolean isMaxFruit(int numOfFruits) {
		return (numOfFruits >= MAX_FRUIT);
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public boolean isEligibleForMore() {
		return (noOfAlcoholDrinks >= MAX_ORDER_FOR_ALCOHOL);
	}

	public int getNumOfAlcoholDrink() {
		return noOfAlcoholDrinks;
	}

	public boolean isValidAge(int age) {
		return (age >= MIN_AGE_FOR_ALCOHOL);
	}

	public Order getCurrentOrder() {
		ArrayList<Order> ordersCopy = new ArrayList<Order>(orders);
		return ordersCopy.get(ordersCopy.size() - 1);
	}

	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		System.out.println("Start a new Order");
		orders.add(new Order(time, day, new Customer(customerName, customerAge)));
	}

	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		if (isValidTime(getCurrentOrder().getOrderTime())) {
			System.out.println("Adding COFFEE drink to order");
			getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
		}

		else
			System.out.println("The order time is invalid");
	}

	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {

		if (isValidTime(getCurrentOrder().getOrderTime()) && numOfFruits <= 5 && numOfFruits >= 0) {
			System.out.println("Adding SMOOTHIE drink to order");
			getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
		}

		else
			System.out.println("The order time or number of fruits is invalid");
	}

	public void processAlcoholOrder(String bevName, Size size) {
		if (isValidTime(getCurrentOrder().getOrderTime()) && isValidAge(getCurrentOrder().getCustomer().getAge())
				&& noOfAlcoholDrinks < MAX_ORDER_FOR_ALCOHOL) {
			System.out.println("Adding ALCOHOL drink to order");
			getCurrentOrder().addNewBeverage(bevName, size);
			noOfAlcoholDrinks++;
		}

		else
			System.out.println("The order time or age is invalid or the max number of alcohol drinks has been reached");
	}

	public int findOrder(int orderNo) {
		int index = 0;
		for (Order order : orders) {
			if (order.getOrderNo() == orderNo)
				return index;
			index++;
		}
		return -1;
	}

	public double totalOrderPrice(int orderNo) {
		return orders.get(orderNo).calcOrderTotal();
	}

	public double totalMonthlySale() {
		double total = 0;
		for (Order orders : orders) {
			total += orders.calcOrderTotal();
		}
		return total;
	}

	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	public Order getOrderAtIndex(int index) {
		return new Order(orders.get(index).getOrderTime(), orders.get(index).getOrderDay(),
				orders.get(index).getCustomer());
	}

	public void sortOrders() {
		int min;
		for (int x = 0; x < orders.size() - 1; x++) {
			min = x;
			for (int y = x + 1; y < orders.size(); y++) {
				if (orders.get(y).calcOrderTotal() < orders.get(min).calcOrderTotal())
					min = y;
				Order temp = new Order(orders.get(min));
				orders.set(min, new Order(orders.get(x)));
				orders.set(x, new Order(temp));
			}
		}
	}

	public String toString() {
		return Arrays.toString(orders.toArray());
	}
}
