package design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.impl;

import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.Duck;
import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.Turkey;

public class DuckAdapter implements Turkey{
	Duck duck;
	
	public DuckAdapter(Duck duck) {
		this.duck = duck;
	}

	@Override
	public void gobble() {
		duck.quack();
	}

	@Override
	public void fly() {
		duck.fly();
	}
}
