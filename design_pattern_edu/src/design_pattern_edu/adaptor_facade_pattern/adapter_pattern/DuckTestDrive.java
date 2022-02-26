package design_pattern_edu.adaptor_facade_pattern.adapter_pattern;

import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.Duck;
import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.Turkey;
import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.impl.DuckAdapter;
import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.impl.MallardDuck;
import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.impl.TurkeyAdapter;
import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.impl.WildTurkey;

/*
 * 7-1. ����� ����(Adapter Pattern)
 * �� Ŭ������ �������̽��� Ŭ���̾�Ʈ���� ����ϰ��� �ϴ� �ٸ� �������̽��� ��ȯ�մϴ�.
 * ����͸� �̿��ϸ� �������̽� ȣȯ�� ���� ������ ���� �� �� ���� Ŭ�������� �����ؼ� �� �� �ֽ��ϴ�.
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
