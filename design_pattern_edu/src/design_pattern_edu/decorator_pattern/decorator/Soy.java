package design_pattern_edu.decorator_pattern.decorator;

import design_pattern_edu.decorator_pattern.beverage.Beverage;

public class Soy extends CondimentDecorator {
	Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", µÎÀ¯";
	}
	
	public double cost() {
		return .15 + beverage.cost();
	}
}
