package design_pattern_edu.decorator_pattern;

import design_pattern_edu.decorator_pattern.beverage.Beverage;
import design_pattern_edu.decorator_pattern.beverage.DarkRoast;
import design_pattern_edu.decorator_pattern.beverage.Espresso;
import design_pattern_edu.decorator_pattern.beverage.HouseBlend;
import design_pattern_edu.decorator_pattern.decorator.Mocha;
import design_pattern_edu.decorator_pattern.decorator.Soy;
import design_pattern_edu.decorator_pattern.decorator.Whip;

/*
 * 3. ���ڷ����� ����(Decorator Pattern)
 * ��ü�� �߰����� ����� �������� ���Ӱ��Ѵ�. ���ڷ����ʹ� ����Ŭ������ ����°��� ���ؼ� ����� �����ϰ� Ȯ���� �� �ִ� ����� ����
 * 
 * ### ������ ��Ģ ###
 * OCP(Open-Closed Principle)
 * Ŭ������ Ȯ�忡 ���ؼ��� ���� �־�� ������, �ڵ� ���濡 ���ؼ��� ���� �־�� �Ѵ�.
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
