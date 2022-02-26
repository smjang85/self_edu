package design_pattern_edu.decorator_pattern.beverage;

public abstract class Beverage {
	String description = "���� ����";
	
	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
}
