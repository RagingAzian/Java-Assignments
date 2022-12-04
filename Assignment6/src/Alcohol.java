
public class Alcohol extends Beverage {
	private boolean isWeekend;
	private final static double WEEKEND_PRICE_INCREASE = .6;

	public Alcohol(String name, Size size, boolean isWeekend) {
		super(name, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}

	public double calcPrice() {
		double price = addSizePrice();
		if (isWeekend)
			price += WEEKEND_PRICE_INCREASE;
		return price;
	}

	public boolean equals(Alcohol alcohol) {
		return (super.equals(alcohol) && this.isWeekend == alcohol.isWeekend);
	}

	public String toString() {
		return ("\n\nName: " + getBeverageName() + "\nSize: " + getSize() + "\nOffered in weekend: " + isWeekend
				+ "\nPrice: " + calcPrice());
	}

	public boolean isWeekend() {
		return isWeekend;
	}
}
