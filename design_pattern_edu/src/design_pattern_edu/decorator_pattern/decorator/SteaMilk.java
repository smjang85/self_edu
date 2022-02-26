package design_pattern_edu.decorator_pattern.decorator;

import design_pattern_edu.decorator_pattern.beverage.Beverage;

public class SteaMilk extends CondimentDecorator {
	Beverage beverage;
	
	public SteaMilk(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", ½ºÆÀ ¹ĞÅ©";
	}
	
	public double cost() {
		return .10 + beverage.cost();
	}
}
