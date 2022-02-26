package design_pattern_edu.decorator_pattern.decorator;

import design_pattern_edu.decorator_pattern.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage{
	public abstract String getDescription();
}
