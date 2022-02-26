package design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.impl;

import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.Turkey;

public class WildTurkey implements Turkey {

	@Override
	public void gobble() {
		System.out.println("Goblle goblle");
		
	}

	@Override
	public void fly() {
		System.out.println("I'm flying a sohrt distance");
	}
	
}
