public abstract class Beverage {
	private String beverageName;
	private Type beverageType;
	private Size size;
	private static final double BASE_PRICE = 2;
	private static final double PRICE_INCREASE = 1;

	public Beverage(String name, Type type, Size size) {
		beverageName = name;
		beverageType = type;
		this.size = size;
	}

	public double addSizePrice() {
		switch (size) {
		case SMALL:
			return BASE_PRICE;
		case MEDIUM:
			return BASE_PRICE + PRICE_INCREASE;
		case LARGE:
			return BASE_PRICE + PRICE_INCREASE * 2;
		default:
			return 0;
		}
	}

	public abstract double calcPrice();

	public String toString() {
		return "\nName: " + beverageName + "\nSize: " + size;
	}

	public boolean equals(Beverage beverage) {
		return (this.beverageName.equals(beverage.beverageName) && this.beverageType.equals(beverage.beverageType)
				&& this.size.equals(beverage.size));
	}

	public Type getBeverageType() {
		return beverageType;
	}

	public String getBeverageName() {
		return beverageName;
	}

	public Size getSize() {
		return size;
	}

	public void setBeverageType(Type type) {
		beverageType = type;
	}

	public void setBeverageName(String name) {
		beverageName = name;
	}

	public void setSize(Size size) {
		this.size = size;
	}
}