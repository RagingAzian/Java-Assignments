
public abstract class Beverage {
	private String beverageName;
	private Type beverageType;
	private Size size;
	static final double BASE_PRICE = 2;
	static final double PRICE_INCREASE = 1;
	
	public Beverage(String name, Type type, Size size) {
		beverageName = name;
		beverageType = type;
		this.size = size;
	}
	public abstract double calcPrice();
	
	public String toString() {
		return "Name: "+beverageName+"\nSize: "+size;
	}
	
	public boolean equals(Beverage beverage) {
		if(this.beverageName.equals(beverage.beverageName) && this.beverageType.equals(beverage.beverageType)&&this.size.equals(beverage.size))
			return true;
		return false;
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
		beverageName =  name;
	}
	public void setSize(Size size) {
		this.size = size;
	}
}
