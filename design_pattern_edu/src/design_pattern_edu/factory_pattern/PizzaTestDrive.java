package design_pattern_edu.factory_pattern;

import design_pattern_edu.factory_pattern.pizza.Pizza;
import design_pattern_edu.factory_pattern.store.ChicagoPizzaStore;
import design_pattern_edu.factory_pattern.store.NYPizzaStore;
import design_pattern_edu.factory_pattern.store.PizzaStore;

/*
 * 4-1. ���丮 �޼ҵ� ����(Factory Pattern)
 * ���丮 �޼ҵ� ���Ͽ����� ��ü�� �����ϱ� ���� �������̽��� �����ϴµ�, � Ŭ������ �ν��Ͻ��� �������� ����Ŭ�������� �����ϰ� ����ϴ�. 
 * ���丮 �޼ҵ� ������ �̿��ϸ� Ŭ������ �ν��Ͻ��� ����� ���� ����Ŭ������ �ñ�� ������.
 * ### ������ ��Ģ ###
 * �߻�ȭ�� �Ϳ� �����ϵ��� ������. ����Ŭ������ �����ϵ��� ������ �ʵ��� �Ѵ�.
 * -> store Ŭ�������� ������(Creator) Ŭ���� ��� �Ѵ�.
 * -> pizza Ŭ�������� ����(Product) Ŭ���� ��� �Ѵ�.
 * 
 * 
 * ## ������ �� ���̵� ����
 *  -> � �������� ���� Ŭ������ ���� ���۷����� �������� ���ô�.
 *  -> ���� Ŭ�������� ������ Ŭ������ ������ ���ô�.
 *  -> ���̽� Ŭ������ �̹� �����Ǿ� �ִ� �޼ҵ带 �������̵����� ���ô�.
 *  
 *  4-2. �߻� ���丮 ����(Factory Pattern)
 *  �������̽��� �̿��Ͽ� ���� ������, �Ǵ� �����ϴ� ��ü�� ���� Ŭ������ �������� �ʰ� ������ �� �ֽ��ϴ�.
 * 
 */
public class PizzaTestDrive {
	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();
		
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");
		
		pizza = chicagoStore.orderPizza("cheese");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");
		
	}
}
