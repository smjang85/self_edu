package design_pattern_edu.decorator_pattern;

import design_pattern_edu.decorator_pattern.beverage.Beverage;
import design_pattern_edu.decorator_pattern.beverage.DarkRoast;
import design_pattern_edu.decorator_pattern.beverage.Espresso;
import design_pattern_edu.decorator_pattern.beverage.HouseBlend;
import design_pattern_edu.decorator_pattern.decorator.Mocha;
import design_pattern_edu.decorator_pattern.decorator.Soy;
import design_pattern_edu.decorator_pattern.decorator.Whip;

/*
 * 3. 데코레이터 패턴(Decorator Pattern)
 * 객체에 추가적인 요건을 동적으로 ㅊ머가한다. 데코레이터는 서브클래스를 만드는것을 통해서 기능을 유연하게 확장할 수 있는 방법을 제공
 * 
 * ### 디자인 원칙 ###
 * OCP(Open-Closed Principle)
 * 클래스는 확장에 대해서는 열려 있어야 하지만, 코드 변경에 대해서는 닫혀 있어야 한다.
 */
public class StarbuzzCoffe {
	public static void main(String args[]) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());
		
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
		
		Beverage beverage3 = new HouseBlend();
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
	}
}
