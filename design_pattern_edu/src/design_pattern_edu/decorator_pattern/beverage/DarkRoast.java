package design_pattern_edu.decorator_pattern.beverage;

public class DarkRoast extends Beverage{
	public DarkRoast() {
		description = "��ũ �ν�Ʈ";
	}
	
	public double cost() {
		return .99;
	}
}
