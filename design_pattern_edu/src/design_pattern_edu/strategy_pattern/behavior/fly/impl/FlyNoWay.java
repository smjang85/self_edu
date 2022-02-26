package design_pattern_edu.strategy_pattern.behavior.fly.impl;

import design_pattern_edu.strategy_pattern.behavior.fly.FlyBehavior;

public class FlyNoWay implements FlyBehavior{
	public void fly() {
		System.out.println("저는 못 날아요");
	}
}
