package design_pattern_edu.strategy_pattern.animal;

import design_pattern_edu.strategy_pattern.behavior.fly.impl.FlyWithWings;
import design_pattern_edu.strategy_pattern.behavior.quack.impl.Quack;

public class MallardDuck extends Duck{
	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
	
	public void display() {
		System.out.println("저는 물오리입니다.");
	}
}
