package design_pattern_edu.decorator_pattern.beverage;

public class Decaf extends Beverage{
	public Decaf() {
		description = "��ī����";
	}
	
	public double cost() {
		return 1.05;
	}
}
