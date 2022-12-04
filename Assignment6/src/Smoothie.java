
public class Smoothie extends Beverage {
	private int numOfFruits;
	private boolean containsProtein;
	private final static double PROTEIN_PRICE = 1.5;
	private final static double FRUIT_PRICE = .5;

	public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
		super(name, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		containsProtein = addProtein;
	}

	public double calcPrice() {
		double price = addSizePrice();
		if (containsProtein)
			price += PROTEIN_PRICE;
		price += FRUIT_PRICE * numOfFruits;

		return price;
	}

	public int getNumOfFruits() {
		return numOfFruits;
	}

	public boolean getContainsProtein() {
		return containsProtein;
	}

	public boolean equals(Smoothie smoothie) {
		return (super.equals(smoothie) && this.numOfFruits == smoothie.numOfFruits
				&& this.containsProtein == smoothie.containsProtein);
	}

	public String toString() {
		return "\n\nName: " + getBeverageName() + "\nSize: " + getSize() + "\nContains Protein: " + containsProtein
				+ "\nNumber of Fruits: " + numOfFruits + "\nPrice: " + calcPrice();
	}
}
