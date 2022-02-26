package design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.impl;

import java.util.Random;

import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.Duck;
import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.Turkey;

public class DuckAdapter implements Turkey{
	Duck duck;
	Random rand;
	
	public DuckAdapter(Duck duck) {
		this.duck = duck;
		rand = new Random();
	}
	

	@Override
	public void gobble() {
		duck.quack();
	}

	@Override
	public void fly() {
		if(rand.nextInt(5) == 0) {
			duck.fly();
		}
	}
}
