package design_pattern_edu.strategy_pattern.animal;

import design_pattern_edu.strategy_pattern.behavior.fly.FlyBehavior;
import design_pattern_edu.strategy_pattern.behavior.quack.QuackBehavior;

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public Duck() {
	}

	public void performFly() {
		flyBehavior.fly();
	}
	
	public void performQuack() {
		quackBehavior.quack();
	}
	
	public void swim() {
		System.out.println("��� ������ ���� ��ϴ�. ��¥ ������ ����");
	}
}
