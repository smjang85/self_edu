package design_pattern_edu.decorator_pattern.decorator;

import design_pattern_edu.decorator_pattern.beverage.Beverage;

public class Mocha extends CondimentDecorator {
	Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", ¸ğÄ«";
	}
	
	public double cost() {
		return .20 + beverage.cost();
	}
}
