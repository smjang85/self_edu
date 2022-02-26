package design_pattern_edu.strategy_pattern.behavior.fly.impl;

import design_pattern_edu.strategy_pattern.behavior.fly.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
	public void fly() {
		System.out.println("날고 있어요!");
	}
}
