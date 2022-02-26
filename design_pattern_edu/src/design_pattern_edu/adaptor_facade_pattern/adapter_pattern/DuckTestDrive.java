package design_pattern_edu.adaptor_facade_pattern.adapter_pattern;

import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.Duck;
import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.Turkey;
import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.impl.DuckAdapter;
import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.impl.MallardDuck;
import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.impl.TurkeyAdapter;
import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.impl.WildTurkey;

/*
 * 7-1. 어댑터 패턴(Adapter Pattern)
 * 한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 다른 인터페이스로 변환합니다.
 * 어댑터를 이용하면 인터페이스 호환성 문제 때문에 같이 쓸 수 없는 클래스들을 연결해서 쓸 수 있습니다.
 */
public class DuckTestDrive {
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();	
		
		WildTurkey turkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		
		Turkey duckAdapter = new DuckAdapter(duck);
		
		
		System.out.println("The Turkey says...");
		turkey.gobble();
		turkey.fly();
		
		System.out.println("\nThe Duck says...");
		testDuck(duck);
		
		System.out.println("\nThe TurkeyAdapter says...");
		testDuck(turkeyAdapter);
		
		System.out.println("\nThe duckAdapter says...");
		testTurkey(duckAdapter);
	}
	
	static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
	
	static void testTurkey(Turkey turkey) {
		turkey.gobble();
		turkey.fly();
	}
}
