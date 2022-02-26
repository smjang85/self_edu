package design_pattern_edu.factory_pattern;

import design_pattern_edu.factory_pattern.pizza.Pizza;
import design_pattern_edu.factory_pattern.store.ChicagoPizzaStore;
import design_pattern_edu.factory_pattern.store.NYPizzaStore;
import design_pattern_edu.factory_pattern.store.PizzaStore;

/*
 * 4-1. 팩토리 메소드 패턴(Factory Pattern)
 * 팩토리 메소드 패턴에서는 객체를 생성하기 위한 인터페이스를 정희하는데, 어떤 클래스의 인스턴스를 만들지는 서브클래서에서 결정하게 만듭니다. 
 * 팩토리 메소드 패턴을 이용하면 클래스의 인스턴스를 만드는 일을 서브클래스에 맡기는 것이죠.
 * ### 디자인 원칙 ###
 * 추상화된 것에 의존하도록 만들어라. 구상클래스에 의종하도록 만들지 않도록 한다.
 * -> store 클래스들을 생산자(Creator) 클래스 라고 한다.
 * -> pizza 클래스들을 제폼(Product) 클래스 라고 한다.
 * 
 * 
 * ## 도움이 될 가이드 라인
 *  -> 어떤 변수에도 구상 클래스에 대한 레퍼런스를 저장하지 맙시다.
 *  -> 구상 클래스에서 유도된 클래스를 만들지 맙시다.
 *  -> 베이스 클래스에 이미 구현되어 있던 메소드를 오버라이드하지 맙시다.
 *  
 *  4-2. 추상 팩토리 패턴(Factory Pattern)
 *  인터페이스를 이용하여 서로 연관된, 또는 의존하는 객체를 구상 클래스를 지정하지 않고도 생성할 수 있습니다.
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
