package design_pattern_edu.decorator_pattern.decorator;

import design_pattern_edu.decorator_pattern.beverage.Beverage;

public class Whip extends CondimentDecorator {
	Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", ÈÖÇÎ Å©¸²";
	}
	
	public double cost() {
		return .10 + beverage.cost();
	}
}
