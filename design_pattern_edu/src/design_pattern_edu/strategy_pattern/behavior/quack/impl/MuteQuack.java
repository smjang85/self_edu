package design_pattern_edu.strategy_pattern.behavior.quack.impl;

import design_pattern_edu.strategy_pattern.behavior.quack.QuackBehavior;

public class MuteQuack implements QuackBehavior{

	public void quack() {
		System.out.println("<< Á¶¿ë~ >>");
	}
}
