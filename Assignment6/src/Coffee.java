public class Coffee extends Beverage {
	private boolean containsShot;
	private boolean containsSyrup;
	private static final double SHOT_PRICE = .5;
	private static final double SYRUP_PRICE = .5;

	public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
		super(name, Type.COFFEE, size);
		containsShot = extraShot;
		containsSyrup = extraSyrup;
	}

	public double calcPrice() {
		double price = addSizePrice();

		if (containsShot)
			price += SHOT_PRICE;
		if (containsSyrup)
			price += SYRUP_PRICE;
		return price;
	}

	public boolean equals(Coffee coffee) {
		if (super.equals(coffee) && this.containsShot == (coffee.containsShot)
				&& this.containsSyrup == (coffee.containsSyrup))
			return true;
		return false;
	}

	public boolean getContainsShot() {
		return containsShot;
	}

	public boolean getContainsSyrup() {
		return containsSyrup;
	}

	public void setContainsShot(boolean shot) {
		containsShot = shot;
	}

	public void setContainsSyrup(boolean syrup) {
		containsSyrup = syrup;
	}

	public String toString() {
		return ("\n\nName: " + getBeverageName() + "\nSize: " + getSize() + "\nContains Extra Shot: " + containsShot
				+ "\nContains Extra Syrup: " + containsSyrup + "\nPrice: " + calcPrice());
	}
}