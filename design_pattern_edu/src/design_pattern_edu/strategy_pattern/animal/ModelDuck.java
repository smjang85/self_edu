package design_pattern_edu.strategy_pattern.animal;

import design_pattern_edu.strategy_pattern.behavior.fly.impl.FlyNoWay;
import design_pattern_edu.strategy_pattern.behavior.quack.impl.Quack;

public class ModelDuck extends Duck{
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}
	
	public void display() {
		System.out.println("저는 모형 오리입니다.");
	}
}
