package design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.impl;

import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.Duck;

public class MallardDuck implements Duck {
	public void quack() {
		System.out.println("Quack");
	}
	
	public void fly() {
		System.out.println("I'm flaying");
	}
}
