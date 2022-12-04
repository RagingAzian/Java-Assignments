/*
 * Class: CMSC203 
 * Instructor: David Kuijt
 * Description: The BevShop offers 3 types of beverages: Coffee, Alcoholic and Smoothie. 
 * Beverages can be ordered in 3 different sizes: Small, medium and large. 
 * All the beverage types has a base price. 
 * In addition, there are additional charges depending on the size and specific add-ons for each type of beverage.
 * Due: 12/04/2022
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Justin Nguyen
*/

public class BevShopDriverApp {
	public static void main(String[] args) {
		final Day day = Day.SUNDAY;
		final int orderTime = 23;
		BevShop bevShop = new BevShop();
		Customer customer = new Customer("Justin", 23);
		bevShop.startNewOrder(orderTime, day, customer.getName(), customer.getAge());
		System.out.println(bevShop.getCurrentOrder().toString());
		bevShop.processSmoothieOrder("Protein Shake", Size.MEDIUM, 2, true);
		bevShop.processSmoothieOrder("Strawberry Smoothie", Size.LARGE, -1, false);
		bevShop.processCoffeeOrder("Latte", Size.SMALL, true, false);
		bevShop.processAlcoholOrder("Whiskey", Size.LARGE);
		bevShop.processAlcoholOrder("Wine", Size.MEDIUM);
		bevShop.processAlcoholOrder("Martini", Size.SMALL);
		bevShop.processAlcoholOrder("This one should be invalid", Size.LARGE);
		System.out.println(bevShop.getCurrentOrder().toString());
		System.out.printf("\nYour order total is : $%.2f", bevShop.getCurrentOrder().calcOrderTotal());
	}

}